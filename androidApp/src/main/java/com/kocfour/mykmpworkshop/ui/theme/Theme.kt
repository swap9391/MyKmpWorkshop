package com.kocfour.mykmpworkshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


val ColorLightPrimaryBlue = Color(0xFF62CDFA)
val ColorSecondaryBlue = Color(0xFF62CDFA)
val ColorGreyContainer = Color(0xFFF4F4F4)
val ColorBlueContainer = Color(0xFFF4FCFF)
val ColorBlueText = Color(0xFF0F80FD)
val ColorLightBlackText = Color(0xFF141A1E)
val ColorLightPrimaryText = Color(0xFF575757)
val ColorSecondaryText = Color(0xFF8E8E8E)
val ColorPrimaryBlueText = Color(0xFF5DCCFC)




/*
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF1C1B1F)
)

private val LightColorScheme = lightColorScheme(
    *//*primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = WhiteColor,
    surface = PrimaryBlueTextColor*//*

    surface = Blue,
    onSurface = Color.White,
    primary = LightBlue,
    onPrimary = Navy

    *//* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    *//*
)*/

private val LightColorScheme = lightColorScheme(
    background = WhiteColor,
    surface = WhiteColor,
    primary = ColorLightPrimaryBlue,
    secondary = ColorLightPrimaryText,
    primaryContainer = ColorLightBlackText
)

private val DarkColorScheme = darkColorScheme(
    background = ColorLightBlackText,
    surface = ColorLightBlackText,
    primary = ColorLightPrimaryBlue,
    secondary = WhiteColor,
    primaryContainer = WhiteColor
)

@Composable
fun ComposeWorkShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    /*val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}