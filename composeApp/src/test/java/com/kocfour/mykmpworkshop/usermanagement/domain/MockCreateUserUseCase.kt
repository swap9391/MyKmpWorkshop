package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.network.commonmodel.ApiResponse
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import kotlinx.coroutines.delay

class MockCreateUserUseCase{} /*: CreateUserUseCase(
    userRepository = object : UserRepository {

        override suspend fun createUser(user: User): Result<ApiResponse> {
            // Instead of calling a real API, return a fake success state
            return Result.success(ApiResponse("User created successfully", "2025-09-21T13:37:02.0217297"))
        }
    }
) {

    override suspend fun invoke(user: User): Result<Any> {
        // Simulate network delay to mimic real async call
        delay(100)

        // Return a fake success result
        return Result.success(ApiResponse("User created successfully", "2025-09-21T13:37:02.0217297"))

    }
}*/
