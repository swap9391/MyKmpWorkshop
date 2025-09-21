package com.kocfour.mykmpworkshop.usermanagement.presentation

import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.domain.MockCreateUserUseCase
import junit.framework.TestCase.assertTrue
import org.junit.Test
import kotlin.test.assertEquals

class SignUpViewModelTest {
    private val viewModel = SignUpViewModel(MockCreateUserUseCase())

    @Test
    fun `validateInput returns failure for empty name`() {
        val user = User(
            name = "",
            email = "test@example.com",
            password = "Test1234",
            mobileNumber = "1234567890",
            role = "USER"
        )

        val result = viewModel.validateInput(user)
        assertTrue(result.isFailure)
        assertEquals("Name cannot be empty", result.exceptionOrNull()?.message)
    }

    @Test
    fun `validateInput returns failure for invalid email`() {
        val user = User(
            name = "John",
            email = "invalidemail",
            password = "Test1234",
            mobileNumber = "1234567890",
            role = "USER"
        )

        val result = viewModel.validateInput(user)
        assertTrue(result.isFailure)
        assertEquals("Invalid email", result.exceptionOrNull()?.message)
    }

    @Test
    fun `validateInput returns failure for short password`() {
        val user = User(
            name = "John",
            email = "john@example.com",
            password = "short",
            mobileNumber = "1234567890",
            role = "USER"
        )

        val result = viewModel.validateInput(user)
        assertTrue(result.isFailure)
        assertEquals("Password must be at least 8 characters", result.exceptionOrNull()?.message)
    }

    @Test
    fun `validateInput returns success for valid user`() {
        val user = User(
            name = "John",
            email = "john@example.com",
            password = "Test1234",
            mobileNumber = "1234567890",
            role = "USER"
        )

        val result = viewModel.validateInput(user)
        assertTrue(result.isSuccess)
    }
}