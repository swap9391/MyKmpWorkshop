package com.kocfour.mykmpworkshop.ui.screens.home.tabs

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.ui.components.slider.MySlider
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.components.toolbar.MyToolbar
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun ProfileSettingScreen(navHostController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        MyToolbar(title = stringResource(R.string.text_profile_setting),
            isBack = true,
            isMenu = false,
            modifier = Modifier.padding(top = 11.dp),
            onMenuClick = {},
            onBackPress = { Log.d("TAG", "Back Clicked") })


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val (profilePic, labelFirstName, labelLastName, labelEmailAddress, labelAge, sliderAge, radioGender, btnUpdate,
                textFieldFirstName, textFieldLastName, textFieldAge, textFieldEmailAddress) = createRefs()

            MyTextView(
                text = stringResource(R.string.text_age_question),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier
                    .constrainAs(labelAge) {
                        top.linkTo(parent.top, margin = 13.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                    }
                    .padding(top = 26.dp))

            MySlider(
                modifier = Modifier
                    .constrainAs(sliderAge) {
                        top.linkTo(labelAge.bottom, margin = 7.dp)
                        start.linkTo(labelAge.start)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth(),
                value = 50f,
                range = 0f..100f, {}
            )

        }


    }
}

@Preview
@Composable
fun DefaultPreviewProfileSetting() {
    ProfileSettingScreen()
}
