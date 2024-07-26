package com.kocfour.mykmpworkshop.ui.screens.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyComposable(title:String , description:String, confirmButtonText:String, dismissButtonText:String) {
    Column {
            AlertDialog(
                onDismissRequest = {  },
                title = { Text(title) },
                text = { Text(description) },
                confirmButton = {
                    Button(onClick = {  }) {
                        Text(confirmButtonText)
                    }
                },
                dismissButton = {
                    Button(onClick = { /* Do something on next */ }) {
                        Text(dismissButtonText)
                    }
                }
            )
    }
}

@Preview
@Composable
fun MyComposablePreview() {
    MyComposable("Shower Setup Incomplete",
        "Your shower setup must be completed before you can use your shower.",
        "Cancel", "Confirm")
}

