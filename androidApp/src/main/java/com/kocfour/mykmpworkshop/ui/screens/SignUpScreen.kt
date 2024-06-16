package com.kocfour.mykmpworkshop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.android.R
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.components.textView.HyperLinkTextView
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun SignUpScreen(navHostController: NavHostController) {
    val context = LocalContext.current

    ComposeWorkShopTheme {
        Box(
            contentAlignment = Alignment.TopCenter, modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(
                    text = stringResource(R.string.text_create_an_account),
                    textStyle = MyTextStyle.TitleBold22,
                    textColor = MaterialTheme.colorScheme.primaryContainer,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )

                MyTextView(
                    text = stringResource(R.string.text_securely_login_to_your_account),
                    textStyle = MyTextStyle.TitleLight14,
                    textColor = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )
                Spacer(modifier = Modifier.padding(top = 45.dp))


                MyEditText(
                    text = "", hint = stringResource(R.string.text_full_name),
                    icon = R.drawable.ic_user_fulname,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "", hint = stringResource(R.string.text_hint_email),
                    icon = R.drawable.ic_user_email,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "", hint = stringResource(R.string.text_enter_contact),
                    icon = R.drawable.ic_user_contact,
                    keyboardType = KeyboardType.Phone,
                    textLength = 12,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "",
                    hint = stringResource(R.string.text_hint_password),
                    icon = R.drawable.ic_user_password,
                    keyboardType = KeyboardType.Password,
                    isPassword = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )

                MyMainButton(buttonTitle = stringResource(R.string.text_button_create_account), modifier = Modifier.padding(25.dp))
                Spacer(modifier = Modifier.padding(top = 20.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MyTextView(
                        text = stringResource(R.string.text_already_have_account),
                        textStyle = MyTextStyle.TitleMedium14,
                        textColor = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    HyperLinkTextView(
                        onClick = {
                            navHostController.navigate(AppConstants.KEY_NAVIGATE_LOGIN){
                                popUpTo(AppConstants.KEY_NAVIGATE_SIGNUP){
                                    inclusive = true
                                }
                            }
                        },
                        text = stringResource(R.string.text_log_in),
                        textStyle = MyTextStyle.TitleMedium14,
                    )
                }

            }

        }

    }
}
