package com.kocfour.mykmpworkshop.ui.screens.home.setgoalwithai


 sealed class WaterGoalUiState {
    /**
     * The initial state, or when no action is currently being performed.
     * The UI might show input fields or a call to action.
     */
    object Idle : WaterGoalUiState()

    /**
     * Indicates that a background operation (e.g., API call) is in progress.
     * The UI might show a loading spinner or disable input.
     */
    object Loading : WaterGoalUiState()

    /**
     * Indicates that the operation completed successfully, and data is available.
     * Contains the actual data to be displayed.
     */
    data class Success<T>(val data: T) : WaterGoalUiState()

    /**
     * Indicates that an error occurred during the operation.
     * Contains a message explaining the error.
     */
    data class Error(val message: String) : WaterGoalUiState()
}