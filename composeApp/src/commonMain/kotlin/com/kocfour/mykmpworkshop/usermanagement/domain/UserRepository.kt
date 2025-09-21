package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.presentation.APIState

interface UserRepository {
    suspend fun createUser(user: User): APIState<Any>
}
