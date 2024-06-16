package com.kocfour.mykmpworkshop.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.android.R
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ColorLightPrimaryText
import com.kocfour.mykmpworkshop.ui.theme.PrimaryLightBlueContainerColor
import com.kocfour.mykmpworkshop.ui.theme.PrimaryLightBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.SecondaryGreyColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle


@Composable
fun OvalBorderButtonWithIcon(
    /*buttonTitle: String,
    isEnable: Boolean = true,
    contentDescription: String = buttonTitle,
    modifier: Modifier = Modifier,
    ,*/
    modifier: Modifier = Modifier,
    iconId: Int = R.drawable.ic_facebook,
    buttonTitle: String,
    onClick: () -> Unit = {}
) {

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = PrimaryLightBlueContainerColor,//if (isPressed) PrimaryBlueTextColor.copy(alpha = 0.7F) else PrimaryBlueTextColor,
        contentColor = Color.Unspecified,
    )


    Box(
        modifier = modifier
            .height(44.dp)
            .semantics { this.contentDescription = contentDescription }
    ) {
        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            colors = buttonColors,
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(1.dp, PrimaryLightBlueTextColor),
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = { onClick.invoke() },
            /*content = @Composable {
                MyTextView(text = buttonTitle.toUpperCase(Locale.current), textStyle = MyTextStyle.Title4Grey, fontType = FontWeight.Medium)
            }*/
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start // Distribute space between icon and text
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = buttonTitle
                )
                MyTextView(
                    text = buttonTitle.toUpperCase(Locale.current),
                    textStyle = MyTextStyle.TitleLight12,
                    textColor = ColorLightPrimaryText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
fun DefaultButtonPreview() {
    OvalBorderButtonWithIcon(buttonTitle = "Facebook",iconId = R.drawable.ic_facebook)
}


