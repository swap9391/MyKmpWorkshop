package com.kocfour.mykmpworkshop.ui.screens.usermanagement

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.network.util.APIState
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.dropdown.MyDropDown
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.components.textView.HyperLinkTextView
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ComposeWorkShopTheme
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import com.kocfour.mykmpworkshop.usermanagement.data.request.User
import com.kocfour.mykmpworkshop.usermanagement.presentation.SignUpViewModel
import org.koin.compose.koinInject

@Composable
fun SignUpScreen(
    navHostController: NavHostController? = null,
    viewModel: SignUpViewModel = koinInject()
) {

    BackHandler {
        navHostController?.navigate(AppConstants.KEY_NAVIGATE_LOGIN)
    }

    val apiState by viewModel.signUpState.collectAsState() // Observe API state
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val fullNameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneNumberValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    LaunchedEffect(apiState) {
        when (apiState) {
            is APIState.Success<*> -> {
                val response = (apiState as APIState.Success<*>).data
                navHostController?.navigate(AppConstants.KEY_NAVIGATE_VERIFICATION)
            }

            is APIState.Error -> {
                errorMessage = (apiState as APIState.Error).message
                showErrorDialog = true
                //Toast.makeText(context, (apiState as APIState.Error).message, Toast.LENGTH_SHORT).show()
            }

            else -> Unit // Idle or Loading → do nothing special here
        }
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
                    onValueChange = {
                        fullNameValue.value = it
                    }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "", hint = stringResource(R.string.text_hint_email),
                    icon = R.drawable.ic_user_email,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {
                        emailValue.value = it
                    }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                Row {
                    MyDropDown(
                        onCountryCodeSelected = {},
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.CenterVertically)
                    )

                    MyEditText(
                        text = "", hint = stringResource(R.string.text_enter_contact),
                        icon = R.drawable.ic_user_contact,
                        keyboardType = KeyboardType.Phone,
                        textLength = 12,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp),
                        onValueChange = {
                            phoneNumberValue.value = it
                        }
                    )
                }


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
                    onValueChange = {
                        passwordValue.value = it
                    }
                )

                MyMainButton(
                    buttonTitle = stringResource(R.string.text_button_create_account),
                    modifier = Modifier.padding(25.dp),
                    onClick = {
                        val user = User(
                            name = fullNameValue.value,
                            email = emailValue.value,
                            mobileNumber = phoneNumberValue.value,
                            role = "USER",
                            password = passwordValue.value
                        )
                        viewModel.signUp(user)
                        //navHostController?.navigate(AppConstants.KEY_NAVIGATE_VERIFICATION)
                    },
                )
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
                            navHostController?.navigate(AppConstants.KEY_NAVIGATE_LOGIN) {
                                popUpTo(AppConstants.KEY_NAVIGATE_SIGNUP) {
                                    inclusive = true
                                }
                            }
                        },
                        text = stringResource(R.string.text_log_in),
                        textStyle = MyTextStyle.TitleMedium14,
                    )
                }

            }

            // Only show loading indicator
            if (apiState is APIState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp), // size of the circle
                    color = MaterialTheme.colorScheme.primary, // use theme color
                    strokeWidth = 4.dp
                )
            }

            if (showErrorDialog) {
                AlertDialog(
                    onDismissRequest = { showErrorDialog = false },
                    title = { MyTextView(text = "Error") },
                    text = { MyTextView(text = errorMessage) },
                    confirmButton = {
                        MyMainButton(buttonTitle = "OK", onClick = { showErrorDialog = false })
                    }
                )
            }
        }

    }
}

@Composable
@Preview(showBackground = false)
fun SignUpPreview() = SignUpScreen()

