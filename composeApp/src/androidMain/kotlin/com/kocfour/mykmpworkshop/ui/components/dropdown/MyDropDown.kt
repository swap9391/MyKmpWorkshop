package com.kocfour.mykmpworkshop.ui.components.dropdown

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun MyDropDown(
    modifier: Modifier,
    onCountryCodeSelected: (String) -> Unit
) {
    val countryCodes = listOf("+91", "+1", "+44", /* ... other country codes */)
    var selectedCountryCode by remember { mutableStateOf(countryCodes.first()) }
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.height(50.dp).width(50.dp), contentAlignment = Alignment.Center) {
        MyTextView(text = selectedCountryCode, textStyle = MyTextStyle.TitleMedium16)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .fillMaxWidth()

        ) {
            countryCodes.forEach { code ->
                DropdownMenuItem(
                    onClick = {
                        selectedCountryCode = code
                        expanded = false
                        onCountryCodeSelected(code)
                    }
                ) {
                    Text(text = code)
                }
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview() {
    MyDropDown(
        modifier = Modifier,
        onCountryCodeSelected = {}
    )
}
