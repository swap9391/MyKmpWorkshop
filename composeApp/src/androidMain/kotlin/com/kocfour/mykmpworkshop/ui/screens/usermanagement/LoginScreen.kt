package com.kocfour.mykmpworkshop.ui.screens.usermanagement

import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.buttons.OvalBorderButtonWithIcon
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.components.textView.HyperLinkTextView
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun LogInScreen(navHostController: NavHostController) {
    val context = LocalContext.current

    BackHandler {
        //Back restricted
    }

    ComposeWorkShopTheme {
        Box(
            contentAlignment = Alignment.TopCenter, modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(
                    text = stringResource(R.string.text_login_screen),
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

                MyMainButton(buttonTitle = stringResource(R.string.text_log_in), modifier = Modifier.padding(25.dp),
                    onClick = {
                    navHostController.navigate(AppConstants.KEY_NAVIGATE_HOME)
                },)
                Spacer(modifier = Modifier.padding(top = 20.dp))

                HyperLinkTextView(
                    onClick = {
                        Toast.makeText(context, "Forgot Password Clicked", Toast.LENGTH_SHORT)
                            .show()
                    },
                    text = stringResource(R.string.text_forgot_password),
                    textStyle = MyTextStyle.TitleLight12,
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

                MyTextView(
                    text = stringResource(R.string.text_continue_with),
                    textStyle = MyTextStyle.TitleMedium12,
                    textColor = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OvalBorderButtonWithIcon(
                        modifier = Modifier.weight(1f),
                        buttonTitle = stringResource(R.string.text_google),
                        iconId = R.drawable.ic_google
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    OvalBorderButtonWithIcon(
                        modifier = Modifier.weight(1f),
                        buttonTitle = stringResource(R.string.text_facebook),
                        iconId = R.drawable.ic_facebook
                    )
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MyTextView(
                        text = stringResource(R.string.text_create_an_account),
                        textStyle = MyTextStyle.TitleMedium12,
                        textColor = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    HyperLinkTextView(
                        onClick = {
                            navHostController.navigate(AppConstants.KEY_NAVIGATE_SIGNUP){
                                popUpTo(AppConstants.KEY_NAVIGATE_LOGIN){
                                    inclusive = true
                                }
                            }
                        },
                        text = stringResource(R.string.text_sign_up),
                        textStyle = MyTextStyle.TitleMedium12,
                    )
                }
                    Spacer(modifier = Modifier.padding(top = 20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        MyTextView(
                            text = stringResource(R.string.text_clicking_continue),
                            textStyle = MyTextStyle.TitleLight10,
                            textColor = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding( end = 2.dp)
                        )
                        HyperLinkTextView(
                            onClick = {
                                Toast.makeText(context, "Terms of service Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            text = stringResource(R.string.text_terms_of_service),
                            textStyle = MyTextStyle.TitleLight10,
                        )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MyTextView(
                        text = stringResource(R.string.text_and),
                        textStyle = MyTextStyle.TitleLight10,
                        textColor = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding( end = 2.dp)
                    )
                    HyperLinkTextView(
                        onClick = {
                            Toast.makeText(context, "Privacy Policy Clicked", Toast.LENGTH_SHORT)
                                .show()
                        },
                        text = stringResource(R.string.text_privacy_policy),
                        textStyle = MyTextStyle.TitleLight10,
                    )

                }


            }

        }

    }
}
