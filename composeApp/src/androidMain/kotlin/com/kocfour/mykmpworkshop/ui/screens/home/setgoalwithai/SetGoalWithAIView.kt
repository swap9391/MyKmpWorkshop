package com.kocfour.mykmpworkshop.ui.screens.home.setgoalwithai

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.ui.components.buttons.OvalBorderButtonWithIcon
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.components.radiogroup.MyRadioGroup
import com.kocfour.mykmpworkshop.ui.components.slider.MySlider
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.components.toolbar.MyToolbar
import com.kocfour.mykmpworkshop.ui.theme.SecondaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
 fun SetGoalWithAI(navController: NavController?=null,
                   viewModel: SetGoalWithAIViewModel = viewModel<SetGoalWithAIViewModel>()
) {

    BackHandler {
        navController?.navigate(AppConstants.KEY_NAVIGATE_HOME)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val exerciseIntensity = rememberSaveable { mutableStateOf("Light") }
        val addressText = rememberSaveable { mutableStateOf("") }
        val ageText = rememberSaveable { mutableStateOf("") }
        val genderText = rememberSaveable { mutableStateOf("Male") }
        val userWeight = rememberSaveable { mutableFloatStateOf(60F) }
        val userHeight = rememberSaveable { mutableFloatStateOf(160F) }



        val isCalculateButtonEnabled by remember {
            derivedStateOf {
                val isAgeValid = ageText.value.isNotBlank() && ageText.value.toIntOrNull() != null && ageText.value.toInt() > 0
                val isGenderValid = genderText.value.isNotBlank()
                val isWeightValid = userWeight.floatValue > 0f
                val isExerciseIntensityValid = exerciseIntensity.value.isNotBlank()
                val isAddressValid = addressText.value.isNotBlank()
                val isHeightValid = userHeight.floatValue > 0f

                isAgeValid && isGenderValid && isWeightValid &&
                        isExerciseIntensityValid && isAddressValid && isHeightValid
            }
        }

        // State for showing/hiding the result dialog
        var showResultDialog by remember { mutableStateOf(false) }
        // State for showing/hiding the loading dialog
        var showLoadingDialog by remember { mutableStateOf(false) }

        val uiState by viewModel.uiState.collectAsState()

        // Use LaunchedEffect to manage dialog visibility based on UI state changes
        LaunchedEffect(uiState) {
            when (uiState) {
                WaterGoalUiState.Loading -> {
                    showLoadingDialog = true
                    showResultDialog = false // Hide result if loading starts again
                }

                is WaterGoalUiState.Success<*> -> {
                    showLoadingDialog = false
                    showResultDialog = true
                }

                is WaterGoalUiState.Error -> {
                    showLoadingDialog = false
                    showResultDialog = true // Show error in the same result dialog for simplicity
                }

                WaterGoalUiState.Idle -> {
                    showLoadingDialog = false
                    showResultDialog = false
                }
            }
        }



        MyToolbar(
            title = stringResource(R.string.set_your_goal_with_ai),
            isBack = true,
            isMenu = false,
            onMenuClick = { },
            modifier = Modifier,
            onBackPress = { navController?.navigate(AppConstants.KEY_NAVIGATE_HOME) })


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val (labelActivityLevel, radioActivityLevel, labelEmailAddress, labelAge, labelGender, radioGender, btnUpdate,
                textFieldAge, textFieldEmailAddress, labelWeight, labelHeight, sliderWeight, sliderHeight) = createRefs()



            MyTextView(
                text = stringResource(R.string.text_gender),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelGender) {
                    top.linkTo(parent.top, margin = 0.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyRadioGroup(
                list = listOf(
                    stringResource(R.string.text_male),
                    stringResource(R.string.text_female)
                ),
                selectedValue = genderText.value,
                modifier = Modifier.constrainAs(radioGender) {
                    top.linkTo(labelGender.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 13.dp)
                },
                onGenderSelected = {
                    genderText.value = it
                })

            MyTextView(
                text = stringResource(R.string.text_age),
                textStyle = MyTextStyle.TitleMedium16, modifier = Modifier.constrainAs(labelAge) {
                    top.linkTo(radioGender.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(
                hint = stringResource(R.string.text_enter_age), text = ageText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Number,
                textLength = 3,
                modifier = Modifier
                    .constrainAs(textFieldAge) {
                        top.linkTo(labelAge.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    if (it.isEmpty() || (it.toIntOrNull() ?: 0) in 0..110) {
                        ageText.value = it
                    }
                })


            MyTextView(
                text = stringResource(R.string.text_address),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelEmailAddress) {
                    top.linkTo(textFieldAge.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(
                hint = stringResource(R.string.text_hint_enter_city_state_country),
                text = addressText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Email,
                modifier = Modifier
                    .constrainAs(textFieldEmailAddress) {
                        top.linkTo(labelEmailAddress.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp),
                onValueChange = {
                    addressText.value = it
                })



            MyTextView(
                text = stringResource(id=R.string.text_user_weight_label,userWeight.floatValue.toInt()),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier
                    .constrainAs(labelWeight) {
                        top.linkTo(textFieldEmailAddress.bottom, margin = 13.dp)
                        start.linkTo(labelGender.start)
                    }
                    .fillMaxWidth())

            MySlider(
                modifier = Modifier
                    .padding(start = 20.dp, end = 40.dp)
                    .constrainAs(sliderWeight) {
                        top.linkTo(labelWeight.bottom, margin = 5.dp)
                        start.linkTo(labelWeight.start)
                        end.linkTo(parent.end)

                    },
                value = userWeight.floatValue,
                range = 0f..200f
            ) {
                userWeight.floatValue = it.toFloat()
            }


            MyTextView(
                text = stringResource(id=R.string.text_user_height_label,userHeight.floatValue.toInt()),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier
                    .constrainAs(labelHeight) {
                        top.linkTo(sliderWeight.bottom, margin = 8.dp)
                        start.linkTo(labelGender.start)
                    }
                    .fillMaxWidth())

            MySlider(
                modifier = Modifier
                    .padding(start = 20.dp, end = 40.dp)
                    .constrainAs(sliderHeight) {
                        top.linkTo(labelHeight.bottom, margin = 5.dp)
                        start.linkTo(labelHeight.start)
                        end.linkTo(parent.end)

                    },
                value = userHeight.floatValue,
                range = 0f..200f
            ) {
                userHeight.floatValue = it.toFloat()
            }


            MyTextView(
                text = "Exercise Intensity",
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelActivityLevel) {
                    top.linkTo(sliderHeight.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyRadioGroup(
                list = listOf("Light", "Moderate", "Intense"),
                selectedValue = exerciseIntensity.value,
                modifier = Modifier.constrainAs(radioActivityLevel) {
                    top.linkTo(labelActivityLevel.bottom, margin = 5.dp)
                    start.linkTo(parent.start, margin = 13.dp)
                },
                onGenderSelected = {
                    exerciseIntensity.value = it
                })

            OvalBorderButtonWithIcon(
                buttonTitle = "Get Goal",
                textStyle = MyTextStyle.TitleSemiBold14,
                isEnable = isCalculateButtonEnabled,
                modifier = Modifier.constrainAs(btnUpdate) {
                    start.linkTo(parent.start, margin = 23.dp)
                    end.linkTo(parent.end, margin = 23.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                }
                    .padding(start = 10.dp, bottom = 10.dp)
                    .size(width = 200.dp, 40.dp),
                iconId = R.drawable.ic_google_gemini,
                onClick = {

                    val params = SetGoalPromptModel(
                        age = ageText.value.toIntOrNull() ?: 0,
                        gender = genderText.value,
                        weight = userWeight.floatValue.toString(),
                        exerciseIntensity = exerciseIntensity.value,
                        address = addressText.value,
                        height = userHeight.floatValue.toString(),
                    )
                    viewModel.generateGoalWithAI(params)
                })


            if (showResultDialog) {
                ResultDialog(
                    uiState = uiState,
                    onDismissRequest = { showResultDialog = false }
                )
            }

        }


        // --- Dialogs ---

        if (showLoadingDialog) {
            LoadingDialog()
        }

        if (showResultDialog) {
            ResultDialog(
                uiState = uiState,
                onDismissRequest = { showResultDialog = false }
            )
        }
    }
}
    @Composable
    @Preview
    fun LoadingDialog() {
        Dialog(onDismissRequest = { /* Prevent dismissal by tapping outside during loading */ }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Lottie animation for AI icon
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ai_loading_animation))
                    val progress by animateLottieCompositionAsState(
                        composition,
                        iterations = LottieConstants.IterateForever // Loop indefinitely
                    )
                    LottieAnimation(
                        composition,
                        progress,
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                    Text("Generating your personalized goal...", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }



@Composable
fun ResultDialog(uiState: WaterGoalUiState, onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            MyTextView(
                text =
                    when (uiState) {
                        is WaterGoalUiState.Success<*> -> "Your Water Goal"
                        is WaterGoalUiState.Error -> "Error"
                        else -> "Result"
                    }
                ,
                textStyle = MyTextStyle.TitleSemiBold18,
                textColor = MaterialTheme.colorScheme.primaryContainer,
                textAlign = TextAlign.Center
            )
        },
        text = {
            Column {
                when (uiState) {
                    is WaterGoalUiState.Success<*> -> {
                      //  HtmlText(uiState.data.toString())

                        // Use AndroidView to wrap a WebView for full HTML/CSS rendering
                        AndroidView(
                            factory = { context ->
                                WebView(context).apply {
                                    layoutParams = ViewGroup.LayoutParams(
                                        ViewGroup.LayoutParams.MATCH_PARENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT
                                    )
                                    // Optional: configure WebView settings if needed
                                    settings.javaScriptEnabled = false // Disable JS unless truly needed for security
                                    webViewClient = WebViewClient() // Prevents opening URLs in external browser
                                    setBackgroundColor(0) // Makes WebView background transparent if dialog has one
                                }
                            },
                            update = { webView ->
                                // Load the HTML content
                                webView.loadDataWithBaseURL(null, uiState.data.toString(), "text/html", "UTF-8", null)
                            }
                        )
                    }
                    is WaterGoalUiState.Error -> {
                        MyTextView(text = uiState.message, textStyle = MyTextStyle.TitleMedium16)
                    }
                    else -> { /* Should not happen */ }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text("OK")
            }
        }
    )
}

/*
@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}*/
