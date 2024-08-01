package com.kocfour.mykmpworkshop.ui.screens.home.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun HomeTab() {
    ConstraintLayout {
        val (greetingText,UserName,)= createRefs()
    }
}