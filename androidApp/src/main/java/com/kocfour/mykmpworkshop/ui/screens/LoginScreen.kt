package com.kocfour.mykmpworkshop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.android.R
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
@Preview
fun LoginScreen() {
    ComposeWorkShopTheme {
        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(text = stringResource(R.string.text_login_screen), textStyle = MyTextStyle.XLargeText, fontType = FontWeight.Bold, textAlign = TextAlign.Left, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp))
                MyTextView(text = stringResource(R.string.text_securely_login_to_your_account), textStyle = MyTextStyle.Title4, fontType = FontWeight.Light, textAlign = TextAlign.Left, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp))
                Spacer(modifier = Modifier.padding(top = 45.dp))
                MyEditText(
                    text = "", hint = stringResource(R.string.text_hint_email), icon = R.drawable.ic_user_email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))
                MyEditText(
                    text = "", hint = stringResource(R.string.text_hint_password), icon = R.drawable.ic_user_password,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )

                MyMainButton(buttonTitle = "Login", modifier = Modifier.padding(14.dp))
            }

        }
    }
}