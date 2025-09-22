package com.kocfour.mykmpworkshop.network.util

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.io.IOException
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
//import kotlinx.serialization.json.JsonDecodingException
import kotlinx.serialization.MissingFieldException
//import java.net.UnknownHostException
//import java.io.IOException

/**
 * Extension function to handle all API exceptions and convert them to Result
 */
suspend inline fun <T> handleApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        val result = apiCall()
        Result.success(result)
    } catch (e: Exception) {
        Result.failure(e.toApiException())
    }
}

/**
 * Extension function to convert exceptions to user-friendly API exceptions
 */
@OptIn(ExperimentalSerializationApi::class)
suspend fun Exception.toApiException(): Exception {
    return when (this) {
        is ClientRequestException -> handleClientError()
        is ServerResponseException -> handleServerError()
        is TimeoutCancellationException -> Exception("Request timeout. Please check your internet connection and try again.")
        //is UnknownHostException -> Exception("No internet connection. Please check your network and try again.")
        //is JsonDecodingException -> Exception("Invalid JSON response from server. Please try again later.")
        is MissingFieldException -> Exception("Incomplete response from server: ${this.message}")
        is SerializationException -> Exception("Response format error: Unable to process server response.")
        is IOException -> Exception("Network communication error. Please check your connection.")
        else -> Exception("An unexpected error occurred: ${this.message ?: "Unknown error"}")
    }
}

/**
 * Handle client errors (4xx)
 */
private suspend fun ClientRequestException.handleClientError(): Exception {
    return when (this.response.status) {
        HttpStatusCode.BadRequest -> {
            try {
                // Try to parse error response for more details
                val errorBody = this.response.body<String>()
                Exception("Bad request: $errorBody")
            } catch (parseError: Exception) {
                Exception("Bad request: Please check your input data.")
            }
        }
        HttpStatusCode.Unauthorized -> Exception("Unauthorized: Please check your authentication credentials.")
        HttpStatusCode.Forbidden -> Exception("Forbidden: You don't have permission to perform this action.")
        HttpStatusCode.NotFound -> Exception("Resource not found: The requested resource does not exist.")
        HttpStatusCode.Conflict -> Exception("Conflict: Resource already exists with the provided information.")
        HttpStatusCode.UnprocessableEntity -> Exception("Invalid data provided.")
        HttpStatusCode.TooManyRequests -> Exception("Too many requests: Please wait before trying again.")
        else -> Exception("Client error: ${this.response.status.description}")
    }
}

/**
 * Handle server errors (5xx)
 */
private fun ServerResponseException.handleServerError(): Exception {
    return when (this.response.status) {
        HttpStatusCode.InternalServerError -> Exception("Server error: Please try again later.")
        HttpStatusCode.BadGateway -> Exception("Service temporarily unavailable. Please try again later.")
        HttpStatusCode.ServiceUnavailable -> Exception("Service is under maintenance. Please try again later.")
        HttpStatusCode.GatewayTimeout -> Exception("Server response timeout. Please try again.")
        else -> Exception("Server error: ${this.response.status.description}")
    }
}

/**
 * Extension function with retry mechanism
 */
 private suspend inline fun <T> handleApiCallWithRetry(
    maxRetries: Int = 3,
    delayMs: Long = 1000L,
    crossinline apiCall: suspend () -> T
): Result<T> {
    var lastException: Exception? = null

    repeat(maxRetries) { attempt ->
        try {
            val result = apiCall()
            return Result.success(result)
        } catch (e: ClientRequestException) {
            // Don't retry on client errors (4xx) - these are likely permanent
            if (e.response.status.value in 400..499) {
                return Result.failure(e.handleClientError())
            }
            lastException = e.handleClientError()
        } catch (e: ServerResponseException) {
            // Retry on server errors (5xx)
            lastException = e.handleServerError()
            if (attempt < maxRetries - 1) {
                kotlinx.coroutines.delay(delayMs * (attempt + 1))
            }
        } catch (e: TimeoutCancellationException) {
            lastException = e.toApiException()
            if (attempt < maxRetries - 1) {
                kotlinx.coroutines.delay(delayMs * 2)
            }
        } catch (e: Exception) {
            lastException = e.toApiException()
        }
    }

    return Result.failure(lastException ?: Exception("Failed after $maxRetries attempts"))
}