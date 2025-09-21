package com.kocfour.mykmpworkshop.usermanagement.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.domain.CreateUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class SignUpViewModel(private val registerUserUseCase: CreateUserUseCase): ViewModel() {

    // State to observe API response
    private val _signUpState = MutableStateFlow<APIState<Any>>(APIState.Idle)
    val signUpState: StateFlow<APIState<Any>> = _signUpState

    fun signUp(user: User) {
        viewModelScope.launch {
            val validationResult = validateInput(user)
            if (validationResult.isSuccess) {
                registerUser(user)
            } else {
                _signUpState.value = APIState.Error(validationResult.exceptionOrNull()?.message ?: "Validation failed")
            }
        }
    }

    // Sign-up function
    fun registerUser(user: User) {
        viewModelScope.launch {
            _signUpState.value = APIState.Loading(true)
            try {
                val response = registerUserUseCase(user)
                _signUpState.value = APIState.Success(response)
            } catch (e: Exception) {
                _signUpState.value = APIState.Error(e.message ?: "Unknown Error")
            } finally {
                _signUpState.value = APIState.Loading(false)
            }
        }
    }

    fun validateInput(user: User): Result<Unit> {
        if (user.name.isBlank()) {
            return Result.failure(Exception("Name cannot be empty"))
        }
        if (user.email.isBlank() || !user.email.contains("@")) {
            return Result.failure(Exception("Invalid email"))
        }
        if (user.password.isBlank() || user.password.length < 8) {
            return Result.failure(Exception("Password must be at least 8 characters"))
        }
        return Result.success(Unit)
    }
}


