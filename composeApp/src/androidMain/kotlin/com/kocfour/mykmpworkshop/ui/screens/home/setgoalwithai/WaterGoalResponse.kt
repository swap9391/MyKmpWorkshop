package com.kocfour.mykmpworkshop.ui.screens.home.setgoalwithai


import com.google.gson.annotations.SerializedName

/**
 * Represents the top-level response structure for the personalized water goal.
 */
data class WaterGoalResponse(
    // Maps the 'water_intake_goal' JSON key to the 'waterIntakeGoal' Kotlin property
    @SerializedName("waterIntakeGoal")
    val waterIntakeGoal: WaterIntakeGoal,

    // Maps the 'weather' JSON key to the 'weather' Kotlin property
    @SerializedName("weather")
    val weather: Weather,

    // Maps the 'hydration_tips' JSON key to the 'hydrationTips' Kotlin property
    @SerializedName("hydrationTips")
    val hydrationTips: List<String>
)

/**
 * Represents the nested 'water_intake_goal' object.
 */
data class WaterIntakeGoal(
    // No @SerializedName needed if Kotlin property name matches JSON key
    val unit: String,
    val value: Float // Use Float or Double depending on desired precision
)

/**
 * Represents the nested 'weather' object.
 */
data class Weather(
    // No @SerializedName needed if Kotlin property name matches JSON key
    val location: String,

    // Maps the 'temperature_celsius' JSON key to the 'temperatureCelsius' Kotlin property
    @SerializedName("temperatureCelsius")
    val temperatureCelsius: Int,

    // No @SerializedName needed if Kotlin property name matches JSON key
    val condition: String,

)
