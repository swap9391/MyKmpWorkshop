package com.kocfour.mykmpworkshop.ui.components.textView

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import com.kocfour.mykmpworkshop.ui.theme.textstyle.TypographyUtils
import com.kocfour.mykmpworkshop.ui.theme.textstyle.TypographyUtils.Companion.MyFontFamily


/**
 * Using KKTextView component you can set text to the textview. It accepts 4 parameters as below.
 *
 * @param text The value of the text to be displayed in textview component
 * @param fontType The fontType is having 3 possible values Light, Medium and Regular. Default is Regular
 * @param textStyle The textStyle is having multiple possible values. e.g XLargeTitle, LargeTitle, Title1, Title2 etc. Default is KKTextStyle.Title1
 * @param textColor The color to be set to the text from KKColor format. Default is KKKColor.PureWhite
 * @param contentDescription This parameter is used for automation test to identify textview component by contentDescriptor. Default value of content descriptor is text you set to KKTextView
 */
@Composable
fun MyTextView(
    text: String,
    fontType: FontWeight = FontWeight.Medium,
    textStyle: MyTextStyle = MyTextStyle.Title1,
    textAlign :TextAlign = TextAlign.Left,
    contentDescription: String = text,
    modifier: Modifier = Modifier,
) {

    Text(
        modifier =modifier,
        text = AnnotatedString(text),
        fontFamily = MyFontFamily,
        fontWeight = fontType,
        textAlign = textAlign,
        style = TypographyUtils.getKKTextStyle(textStyle),
    )
}


@Preview
@Composable
fun DefaultPreview() {
    MyTextView(
        text = "Welcome\nKohler", textStyle = MyTextStyle.XLargeTextWhite
    )
}

