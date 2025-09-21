package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User

open class CreateUserUseCase(private val userRepository: UserRepository) {
    open suspend operator fun invoke(user: User): APIState<Any> {
        return userRepository.createUser(user)
    }
}