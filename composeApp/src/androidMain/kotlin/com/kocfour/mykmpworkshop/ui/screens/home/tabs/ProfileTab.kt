package com.kocfour.mykmpworkshop.ui.screens.home.tabs

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.ui.components.buttons.MyMainButton
import com.kocfour.mykmpworkshop.ui.components.edittext.MyEditText
import com.kocfour.mykmpworkshop.ui.components.imageview.MyImageView
import com.kocfour.mykmpworkshop.ui.components.radiogroup.MyRadioGroup
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.components.toolbar.MyToolbar
import com.kocfour.mykmpworkshop.ui.theme.SecondaryBlueTextColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

/**
 * Composable function that represents the profile screen of the application.
 */
@Composable
fun ProfileTab() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val isUpdate = rememberSaveable { mutableStateOf(false) }

        val firstNameText = rememberSaveable { mutableStateOf("") }
        val lastNameText = rememberSaveable { mutableStateOf("") }
        val emailAddressText = rememberSaveable { mutableStateOf("") }
        val ageText = rememberSaveable { mutableStateOf("") }
        val genderText = rememberSaveable { mutableStateOf("Male") }


        MyToolbar(title = "Edit Profile",
            imageRes = R.drawable.ic_edit,
            isBack = true,
            isMenu = true,
            onMenuClick = { isUpdate.value = true },
            modifier = Modifier,
            onBackPress = { Log.d("TAG", "Back Clicked") })


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val (profilePic, labelFirstName, labelLastName, labelEmailAddress, labelAge, labelGender, radioGender, btnUpdate,
                textFieldFirstName, textFieldLastName, textFieldAge, textFieldEmailAddress) = createRefs()



            MyImageView(
                imageRes = getProfileImageResource(genderText, ageText),
                modifier = Modifier
                    .constrainAs(profilePic) {
                        top.linkTo(parent.top, margin = 14.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
                    .height(100.dp)
                    .width(100.dp))

            MyTextView(
                text = "First Name",
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelFirstName) {
                    top.linkTo(profilePic.bottom, margin = 23.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = "Enter First Name", text = firstNameText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldFirstName) {
                        top.linkTo(labelFirstName.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    firstNameText.value = it
                })


            MyTextView(
                text = "Last Name",
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelLastName) {
                    top.linkTo(textFieldFirstName.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = "Enter Last Name", text = lastNameText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldLastName) {
                        top.linkTo(labelLastName.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    lastNameText.value = it
                })


            MyTextView(
                text = "Age",
                textStyle = MyTextStyle.TitleMedium16, modifier = Modifier.constrainAs(labelAge) {
                    top.linkTo(textFieldLastName.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = "Enter Age", text = ageText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Number,
                textLength = 3,
                isEnable = isUpdate.value,
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
                text = "Email Address",
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelEmailAddress) {
                    top.linkTo(textFieldAge.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = "Enter Email Address", text = emailAddressText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Email,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldEmailAddress) {
                        top.linkTo(labelEmailAddress.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    emailAddressText.value = it
                })


            MyTextView(
                text = "Gender",
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelGender) {
                    top.linkTo(textFieldEmailAddress.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyRadioGroup(list = listOf("Male", "Female"),
                selectedValue = genderText.value,
                modifier = Modifier.constrainAs(radioGender) {
                    top.linkTo(labelGender.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 13.dp)
                },
                isEnable = isUpdate.value,
                onGenderSelected = {
                    genderText.value = it
                })

            if (isUpdate.value) {
                MyMainButton(buttonTitle = "Update", isUpperCase = false,
                    modifier = Modifier
                        .constrainAs(btnUpdate) {
                            top.linkTo(radioGender.bottom, margin = 13.dp)
                            start.linkTo(parent.start, margin = 23.dp)
                            end.linkTo(parent.end, margin = 23.dp)
                            bottom.linkTo(parent.bottom, margin = 30.dp)
                        }
                        .width(121.dp)
                        .padding(bottom = 30.dp))

            }

        }
    }
}

private fun getProfileImageResource(
    genderText: MutableState<String>,
    ageText: MutableState<String>
) = when {

    genderText.value == "Male" && ageText.value.isEmpty() -> {
        R.drawable.ic_profile_male_junior
    }

    genderText.value == "Female" && ageText.value.isEmpty() -> {
        R.drawable.ic_profile_female_junior
    }

    genderText.value == "Male" && ageText.value.toInt() < 18 -> {
        R.drawable.ic_profile_male_junior
    }

    genderText.value == "Male" && ageText.value.toInt() > 18 && ageText.value.toInt() < 60 -> {
        R.drawable.ic_profile_male
    }

    genderText.value == "Male" && ageText.value.toInt() > 60 -> {
        R.drawable.ic_profile_male_senior
    }

    genderText.value == "Female" && ageText.value.toInt() < 18 -> {
        R.drawable.ic_profile_female_junior
    }

    genderText.value == "Female" && ageText.value.toInt() > 18 && ageText.value.toInt() < 60 -> {
        R.drawable.ic_profile_female
    }

    genderText.value == "Female" && ageText.value.toInt() > 60 -> {
        R.drawable.ic_profile_female_senior
    }

    else -> {
        R.drawable.ic_profile_male_junior
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ProfileTab()
}
