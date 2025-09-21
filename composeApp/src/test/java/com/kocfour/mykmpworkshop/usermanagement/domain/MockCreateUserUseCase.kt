package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import kotlinx.coroutines.delay

// Define a mock class for testing purposes
// It inherits from your real CreateUserUseCase
class MockCreateUserUseCase : CreateUserUseCase(

    // Provide a dummy UserRepository to satisfy the constructor of CreateUserUseCase
    // Here we use an anonymous object implementing UserRepository
    userRepository = object : UserRepository {

        // Override the createUser function to return a mocked success immediately
        override suspend fun createUser(user: User): APIState<Any> {
            // Instead of calling a real API, return a fake success state
            return APIState.Success("Mocked Success")
        }
    }
) {

    // Override the invoke() operator function from CreateUserUseCase
    // This is what SignUpViewModel would call during tests
    override suspend fun invoke(user: User): APIState<Any> {
        // Simulate network delay to mimic real async call
        delay(100)

        // Return a fake success result
        return APIState.Success("Mocked Success")
    }
}
