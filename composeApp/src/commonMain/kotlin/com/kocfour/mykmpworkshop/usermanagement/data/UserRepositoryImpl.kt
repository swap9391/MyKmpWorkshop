package com.kocfour.mykmpworkshop.usermanagement.data

import com.kocfour.mykmpworkshop.network.commonmodel.ApiResponse
import com.kocfour.mykmpworkshop.network.util.handleApiCall
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.domain.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserRepositoryImpl(
    private val client: HttpClient,
    private val baseUrl: String
) : UserRepository {
    private val endpoint = "$baseUrl/add-user"

    override suspend fun createUser(user: User): Result<ApiResponse> {
        return handleApiCall {
            client.post(endpoint) {
                contentType(ContentType.Application.Json)
                setBody(user)
            }.body<ApiResponse>()
        }
    }
}