package com.kocfour.mykmpworkshop.di

import com.kocfour.mykmpworkshop.network.HttpClientFactory
import com.kocfour.mykmpworkshop.usermanagement.data.UserRepositoryImpl
import com.kocfour.mykmpworkshop.usermanagement.domain.CreateUserUseCase
import com.kocfour.mykmpworkshop.usermanagement.domain.UserRepository
import com.kocfour.mykmpworkshop.usermanagement.presentation.SignUpViewModel
import org.koin.dsl.module

val appModule = module {
    // Provide HttpClient
    single { HttpClientFactory.create() }

    // Provide Base URL
    single { "http://localhost:8080" }

    // Provide Repository
    single<UserRepository> { UserRepositoryImpl(get(), get()) }

    // UseCase
    single { CreateUserUseCase(get()) }
    // ViewModel
    single { SignUpViewModel(get()) }
}
