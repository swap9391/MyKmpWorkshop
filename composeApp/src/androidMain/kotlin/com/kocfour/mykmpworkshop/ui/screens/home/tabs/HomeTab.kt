package com.kocfour.mykmpworkshop.ui.screens.home.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButtonOvalWhite
import com.kocfour.mykmpworkshop.ui.components.buttons.OvalBorderButtonWithIcon
import com.kocfour.mykmpworkshop.ui.components.imageview.MyImageView
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
@Preview
fun HomeTab(navController: NavController?=null) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        MyTextView(
            modifier = Modifier.padding(top = 24.dp),
            text = "Good Morning",
            textStyle = MyTextStyle.TitleLight14,
            textColor = MaterialTheme.colorScheme.primaryContainer
        )

        MyTextView(
            text = "Swapnil,",
            textStyle = MyTextStyle.TitleLight20,
            textColor = MaterialTheme.colorScheme.primaryContainer
        )

        Box(modifier = Modifier.padding(top = 10.dp)) {
            CardViewAddGlasses()
        }

        Box(modifier = Modifier.padding(top = 10.dp)) {
            CardViewSetGoal(navController)
        }

    }
}


@Composable
fun CardViewAddGlasses() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), // Set a fixed height for the card
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {


        Box {
            // 1. Background Image

            MyImageView(
                modifier = Modifier.fillMaxSize(),
                imageRes = R.drawable.img_add_water_bg
            )


            // 2. Content (Text and Button)
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start // Align content to the start (left)
            ) {

                MyTextView(
                    text = "200ml water(2 Glass)",
                    modifier = Modifier.padding(start = 10.dp, bottom = 20.dp, top = 20.dp),
                    textStyle = MyTextStyle.TitleLight20,
                    textColor = Color.Black
                )

                MyMainButtonOvalWhite(
                    buttonTitle = "Add Glass",
                    contentDescription = "Add Glass",
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 10.dp)
                        .size(width = 150.dp, 40.dp),
                    textStyle = MyTextStyle.TitleSemiBold12,
                    onClick = {

                    })

            }
        }
    }
}


@Composable
fun CardViewSetGoal(navController: NavController?) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp), // Set a fixed height for the card
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {


        Box {
            // 1. Background Image
            MyImageView(
                modifier = Modifier.fillMaxSize(),
                imageRes = R.drawable.img_water_waves_bg
            )
            // 2. Content (Text and Button)
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start // Align content to the start (left)
            ) {

                MyTextView(
                    text = "Set Goal",
                    modifier = Modifier.padding(start = 10.dp, bottom = 20.dp, top = 20.dp),
                    textStyle = MyTextStyle.TitleLight16,
                    textColor = Color.Black
                )

                OvalBorderButtonWithIcon(
                    buttonTitle = "Set your goal with AI",
                    textStyle = MyTextStyle.TitleSemiBold12,
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 10.dp)
                        .size(width = 230.dp, 40.dp),
                    iconId = R.drawable.ic_google_gemini,
                    onClick = {
                        navController?.navigate(AppConstants.KEY_NAVIGATE_SET_GOAL)
                    })

            }
        }
    }
}