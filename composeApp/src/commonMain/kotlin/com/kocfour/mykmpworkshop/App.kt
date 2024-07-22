package com.kocfour.mykmpworkshop
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {

            Text(
                text = AnnotatedString("Hello World"),
                textAlign = TextAlign.Center,
                color = Color.Black,
            )

        }
        //MySplashScreen(getString(R.string.text_drop_water_tracker), getString(R.string.text_drop_water_tracker_subtitle))
    }

}