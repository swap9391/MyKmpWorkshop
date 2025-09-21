package com.kocfour.mykmpworkshop.usermanagement.domain

import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User

interface UserRepository {
    suspend fun createUser(user: User): APIState<Any>
}
