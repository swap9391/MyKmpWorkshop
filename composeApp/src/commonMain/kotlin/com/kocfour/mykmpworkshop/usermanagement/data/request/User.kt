package com.kocfour.mykmpworkshop.usermanagement.data.request

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String,
    val mobileNumber: String,
    val role: String,
    val password:  String
)