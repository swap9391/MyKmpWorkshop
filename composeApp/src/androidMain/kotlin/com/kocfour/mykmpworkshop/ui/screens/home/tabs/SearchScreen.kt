package com.kocfour.mykmpworkshop.ui.screens.home.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

/**
 * Composable function that represents the search screen of the application.
 */
@Composable
fun SearchScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyTextView(
            text = "Search Screen",
            textStyle = MyTextStyle.TitleLight18,
            textColor = MaterialTheme.colorScheme.primaryContainer
        )
    }
}