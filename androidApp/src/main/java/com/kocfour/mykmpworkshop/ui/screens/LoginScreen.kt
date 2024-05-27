package com.kocfour.mykmpworkshop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.components.MyTextView
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
@Preview
fun LoginScreen() {
    ComposeWorkShopTheme {
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(text = "Login Screen", textStyle = MyTextStyle.XLargeText, fontType = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(30.dp))
                MyMainButton(buttonTitle = "Login", modifier = Modifier.padding(14.dp))
            }

        }
    }
}