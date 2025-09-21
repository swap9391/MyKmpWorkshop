package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.presentation.APIState

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): APIState<Any> {
        return userRepository.createUser(user)
    }
}