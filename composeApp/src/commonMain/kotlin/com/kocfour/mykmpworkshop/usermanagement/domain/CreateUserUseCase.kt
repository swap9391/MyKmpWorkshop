package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.usermanagement.data.request.User

class CreateUserUseCase(private val userRepository: UserRepository) {
     suspend operator fun invoke(user: User): Result<Any> {
        return userRepository.createUser(user)
    }
}