package com.kocfour.mykmpworkshop.ui.components.radiogroup

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ColorLightPrimaryText
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun MyRadioGroup(
    list: List<String>,
    selectedValue: String,
    textStyle: MyTextStyle = MyTextStyle.TitleMedium14,
    modifier: Modifier,
    isEnable: Boolean = true,
    onGenderSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        list.forEach { gender ->
            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.secondary,
                    disabledSelectedColor = ColorLightPrimaryText,
                    disabledUnselectedColor = ColorLightPrimaryText
                ),
                selected = gender == selectedValue,
                enabled = isEnable,
                onClick = { onGenderSelected(gender) }
            )
            MyTextView(
                text = gender,
                textStyle = textStyle
            )
        }

    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyRadioGroup(list = listOf("Male", "Female"),
        selectedValue = "Male", onGenderSelected = { }
        , modifier = Modifier)
}
