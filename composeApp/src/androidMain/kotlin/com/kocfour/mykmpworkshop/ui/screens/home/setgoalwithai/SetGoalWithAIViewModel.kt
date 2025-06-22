package com.kocfour.mykmpworkshop.ui.screens.home.setgoalwithai

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.ai.GenerativeModel
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SetGoalWithAIViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<WaterGoalUiState>(WaterGoalUiState.Idle)
    val uiState: StateFlow<WaterGoalUiState> = _uiState.asStateFlow()

    private var firebaseModel: GenerativeModel = Firebase.ai(backend = GenerativeBackend.googleAI())
        .generativeModel("gemini-2.0-flash")

    @SuppressLint("SuspiciousIndentation")
    fun generateGoalWithAI(params: SetGoalPromptModel) {
        viewModelScope.launch {
            _uiState.value = WaterGoalUiState.Loading
            delay(3.seconds.inWholeMilliseconds)
            try {
                val prompt = """
                Based on the following characteristics, generate a personalized daily water intake goal,exact current weather 'now' in Celsius and short tips for an individual.
                Provide the response in a well-formatted HTML snippet, Use inline CSS for styling with color of highlight points are in color #62CDFA and others in #141A1E.
                More emphasise on Water Intake goal(Highlight it bold and bigger font), and answer should be maximum 250 characters. 
                DO NOT wrap the HTML in markdown code blocks.
                
                
                - Age: ${params.age} years old 
                - Biological Sex: ${params.gender} 
                - Weight: ${params.weight} kg 
                - Height: ${params.height} cm 
                - Exercise Level: ${params.exerciseIntensity} 
                - Location: ${params.address} 
                
                The HTML snippet should begin directly with a HTML tag (e.g., `<div>`) and end directly with a closing HTML tag (e.g., `</div>`).
                """.trimIndent()



                Log.d("SET Goal Prompt :", prompt)
                val response = firebaseModel.generateContent(prompt)

                var htmlString = response.text
                if (!htmlString.isNullOrBlank()) {
                    // --- IMPORTANT: Strip Markdown code block delimiters ---
                    htmlString = htmlString
                        .removePrefix("```html\n") // Remove starting ```html and newline
                        .replace("`","")     // Remove newline and ending ```
                        .trim()                    // Trim any remaining whitespace

                        Log.d("SET Goal Information :", htmlString.toString())
                        _uiState.value = WaterGoalUiState.Success(htmlString)

                } else {
                    _uiState.value = WaterGoalUiState.Error("Gemini returned an empty HTML response.")
                }

            }catch (e:Exception){
                _uiState.value = WaterGoalUiState.Error("Error: ${e.message}")
            }

        }
    }

    private fun getCurrentTimestampMillis(): Long {
        return System.currentTimeMillis()
    }
}