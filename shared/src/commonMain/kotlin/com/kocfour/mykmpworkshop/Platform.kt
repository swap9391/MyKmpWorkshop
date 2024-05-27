package com.kocfour.mykmpworkshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform