package com.kocfour.mykmpworkshop.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.PrimaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.WhiteColor
import com.kocfour.mykmpworkshop.ui.theme.WhiteDisableColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle


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
fun MyMainButtonOvalWhite(
    buttonTitle: String,
    isEnable: Boolean = true,
    contentDescription: String = buttonTitle,
    modifier: Modifier = Modifier,
    isUpperCase: Boolean = true,
    textStyle: MyTextStyle = MyTextStyle.TitleSemiBold14,
    onClick: () -> Unit = {},
) {

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        disabledContainerColor = Color.White.copy(alpha = 0.8F),
        disabledContentColor = WhiteDisableColor
    )


    Box(
        modifier = modifier
            .semantics { this.contentDescription = contentDescription }
    ) {


        Button(modifier = Modifier
            .wrapContentSize(),
            enabled = isEnable,
            colors = buttonColors,
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp

            ),
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = { onClick.invoke() }, content = @Composable {
                MyTextView(text = if(isUpperCase){ buttonTitle.toUpperCase(Locale.current)}else{buttonTitle}
                    , textStyle = textStyle
                    , textColor = Color.Black)
            }
        )
    }
}


@Preview
@Composable
fun DefaultPreviewOvalButton() {
    MyMainButtonOvalWhite(buttonTitle = "Submit", isUpperCase = false)
}

