package com.kocfour.mykmpworkshop.ui.screens.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.textView.HyperLinkTextView
import com.kocfour.mykmpworkshop.ui.screens.onboarding.model.OnboardingScreenDetails
import com.kocfour.mykmpworkshop.ui.theme.PrimaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.PrimaryLightBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import kotlinx.coroutines.launch

@Composable
fun WelcomeSlideViewScreen(navHostController: NavHostController? = null) {

    val onboardingScreens = listOf(
        OnboardingScreenDetails(
            title = stringResource(id = R.string.text_title_slide_one),
            subtitle = stringResource(id = R.string.text_subtitle_slide_one),
            buttonText = "Next",
            imageRes = R.drawable.img_slider_1 // Replace with your actual drawable
        ),
        OnboardingScreenDetails(
            title = stringResource(id = R.string.text_title_slide_two),
            subtitle = stringResource(id = R.string.text_subtitle_slide_two),
            buttonText = "Next",
            imageRes = R.drawable.img_slider_2 // Replace with your actual drawable
        ),
        OnboardingScreenDetails(
            title = stringResource(id = R.string.text_title_slide_three),
            subtitle = stringResource(id = R.string.text_subtitle_slide_three),
            buttonText = "Next",
            imageRes = R.drawable.img_slider_3 // Replace with your actual drawable
        )
        // ... add more onboarding screens
    )


    val pagerState = rememberPagerState(pageCount = { onboardingScreens.size })

    val coroutineScope = rememberCoroutineScope()

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (pager, indicator, button,skip) = createRefs()


        HyperLinkTextView(
            text = stringResource(R.string.text_skip_all),
            textStyle = MyTextStyle.TitleLight14,
            unselectedColor = PrimaryBlueTextColor,
            selectedColor = PrimaryLightBlueTextColor,
            modifier = Modifier
                .constrainAs(skip) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 25.dp, top = 25.dp),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(2)
                }
            }
        )

        HorizontalPager(
            state = pagerState,
            Modifier
                .constrainAs(pager) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 70.dp),
            contentPadding = PaddingValues(horizontal = 10.dp), pageSpacing = 10.dp
        ) { page ->

            OnboardingScreenContent(screen = onboardingScreens[page])
           /* LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }
                    .collect { currentPage ->
                        pagerState.animateScrollToPage(currentPage)
                    }
            }*/
        }


        Box(
            modifier = Modifier
                .constrainAs(indicator) {
                    top.linkTo(pager.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 20.dp)
        ) {
            IndicatorDots(
                currentPage = pagerState.currentPage,
                totalPages = onboardingScreens.size
            )
        }

        MyMainButton(buttonTitle = when (pagerState.currentPage) {
            2 -> {
                stringResource(R.string.text_get_started)
            }

            else -> {
                stringResource(R.string.text_next)
            }
        }, modifier = Modifier
            .padding(25.dp)
            .constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .padding(bottom = 20.dp),
            onClick = {
                when (pagerState.currentPage) {
                    2 -> {
                        navHostController?.navigate(AppConstants.KEY_NAVIGATE_LOGIN)
                    }

                    else -> {
                        val nextPage = (pagerState.currentPage + 1)
                        // Use coroutineScope to launch the animation within the composable's lifecycle
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(nextPage)
                        }
                    }
                }
            })


    }
}

@Composable
@Preview(showBackground = false)
fun DefaultTemperaturePreview() = WelcomeSlideViewScreen()