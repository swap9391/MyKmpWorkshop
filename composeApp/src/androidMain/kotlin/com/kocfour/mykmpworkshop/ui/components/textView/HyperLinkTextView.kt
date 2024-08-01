package com.kocfour.mykmpworkshop.ui.components.textView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.kocfour.mykmpworkshop.ui.theme.ButtonElevationColor
import com.kocfour.mykmpworkshop.ui.theme.PrimaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import com.kocfour.mykmpworkshop.ui.theme.textstyle.TypographyUtils

@Composable
fun HyperLinkTextView(
    onClick: () -> Unit = {},
    text: String,
    fontType: FontWeight = FontWeight.Medium,
    textStyle: MyTextStyle = MyTextStyle.TitleLight12,
    modifier: Modifier = Modifier,
    unselectedColor : Color = ButtonElevationColor,
    selectedColor : Color = PrimaryBlueTextColor
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val textColor = if (isPressed) selectedColor else unselectedColor

    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            )
        ) { // Style the clickable part
            append(text)
        }
    }


    Text(
        text = annotatedText,
        color = textColor,
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        ),
        fontWeight = fontType,
        style = TypographyUtils.getKKTextStyle(textStyle),
    )
}