package com.kocfour.mykmpworkshop.network.commonmodel

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String
)