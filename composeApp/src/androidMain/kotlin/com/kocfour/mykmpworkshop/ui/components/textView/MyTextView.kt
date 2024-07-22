package com.kocfour.mykmpworkshop.ui.components.textView

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import com.kocfour.mykmpworkshop.ui.theme.textstyle.TypographyUtils


@Composable
fun MyTextView(
    text: String,
    textStyle: MyTextStyle = MyTextStyle.TitleMedium12,
    textAlign :TextAlign = TextAlign.Left,
    textColor : Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
) {

        Text(
            modifier = modifier,
            text = AnnotatedString(text),
            textAlign = textAlign,
            color = textColor,
            style = TypographyUtils.getKKTextStyle(textStyle),
        )
    }


@Preview
@Composable
fun DefaultPreview() {
    MyTextView(
        text = "Welcome\nKohler", textStyle = MyTextStyle.TitleMedium12
    )
}

