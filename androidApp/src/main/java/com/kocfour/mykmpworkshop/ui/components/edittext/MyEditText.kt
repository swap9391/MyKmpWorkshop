package com.kocfour.mykmpworkshop.ui.components.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.android.R
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.GreyColor
import com.kocfour.mykmpworkshop.ui.theme.PrimaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.PrimaryRedTextColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun MyEditText(
    hint: String,
    text: String,
    icon: Int,
    fontType: FontWeight = FontWeight.Medium,
    textStyle: MyTextStyle = MyTextStyle.TextFieldHint,
    textAlign: TextAlign = TextAlign.Left,
    isEnable: Boolean = true,
    modifier: Modifier = Modifier,
    onValueChange: ((updatedValue: String) -> Unit)
) {
    var input by rememberSaveable { mutableStateOf(text) }
    OutlinedTextField(
        value = text,
        enabled = isEnable,
        modifier = modifier.apply {
            fillMaxWidth()
            height(50.dp)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "null", tint = Color.Unspecified
            )
        },
        placeholder = {
            MyTextView(
                text = hint,
                textStyle = textStyle,
                textAlign = textAlign,
                fontType = fontType
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Unspecified,
            unfocusedIndicatorColor = Color.Unspecified,
            cursorColor = PrimaryBlueTextColor,
            unfocusedContainerColor = GreyColor,
            focusedContainerColor = GreyColor,
            errorContainerColor = PrimaryRedTextColor
        ),
        onValueChange = {
            input = it
            onValueChange.invoke(it)
        }
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyEditText(
        text = "", hint = "Enter Username", icon = R.drawable.ic_user_email, onValueChange = {}
    )
}