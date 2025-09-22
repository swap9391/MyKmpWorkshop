package com.kocfour.mykmpworkshop.usermanagement.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.domain.CreateUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
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
            flow { emit(registerUserUseCase(user)) }
                .onStart { _signUpState.value = APIState.Loading(true) }
                .map { result ->
                    result.fold(
                        onSuccess = { APIState.Success(it) },
                        onFailure = { APIState.Error(it.message ?: "Error") }
                    )
                }.onCompletion { _signUpState.value = APIState.Loading(false) }
                .collect { state ->
                    _signUpState.value = state
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


