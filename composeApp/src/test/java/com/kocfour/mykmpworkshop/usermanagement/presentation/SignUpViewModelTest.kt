package com.kocfour.mykmpworkshop.usermanagement.presentation

import com.kocfour.mykmpworkshop.network.commonmodel.ApiResponse
import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.domain.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)

class SignUpViewModelTest {
    private lateinit var viewModel: SignUpViewModel
    private lateinit var createUserUseCase : CreateUserUseCase
    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setup(){
        Dispatchers.setMain(testDispatcher)

        createUserUseCase = mock(CreateUserUseCase::class.java)

        viewModel = SignUpViewModel(createUserUseCase)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `registerUser returns success`() = runTest {
        // Arrange
        val user = User(
            name = "Swapnil J",
            email = "test@example.com",
            password = "Test1234",
            mobileNumber = "1234567890",
            role = "USER"
        )
        val response = Result.success(
            ApiResponse("User created successfully", "2025-09-21T13:37:02.0217297")
        )
        whenever(createUserUseCase(user)).thenReturn(response)

        // Collect emitted states
        val states = mutableListOf<APIState<*>>()
        val job = launch(UnconfinedTestDispatcher()) {
            viewModel.signUpState.collect { states.add(it) }
        }

        // Act
        viewModel.registerUser(user)
        advanceUntilIdle() // Makes sure all coroutines finish

        // Cancel collector
        job.cancel()

        // Assert - find the Success state
        val successState = states.filterIsInstance<APIState.Success<*>>().firstOrNull()
        assertNotNull(successState) // Now it should exist

        val actualData = successState?.data as ApiResponse
        val expectedData = response.getOrNull()
        assertEquals(expectedData, actualData)
    }

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


    @AfterTest
    fun tearDown() {
        // Reset Main after test
        Dispatchers.resetMain()
    }



}