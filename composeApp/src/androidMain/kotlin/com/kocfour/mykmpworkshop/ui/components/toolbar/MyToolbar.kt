package com.kocfour.mykmpworkshop.ui.components.toolbar

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle

@Composable
fun MyToolbar(
    title: String,
    imageRes: Int,
    isBack: Boolean,
    isMenu: Boolean,
    onMenuClick: () -> Unit,
    onBackPress: () -> Unit,
    modifier: Modifier
) {
    ConstraintLayout(
        modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {

        var isBackPressed by remember { mutableStateOf(false) }

        var isMenuPressed by remember { mutableStateOf(false) }

        val (menu, tvTitle, back) = createRefs()

        if (isBack)
            IconButton(onClick = onBackPress, modifier = Modifier
                .constrainAs(back) {
                    start.linkTo(parent.start, margin = 19.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            isBackPressed = true
                            tryAwaitRelease()
                            isBackPressed = false
                        })
                }, colors = IconButtonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = Color.Unspecified,
                disabledContainerColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.primary
            )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    tint = if (isBackPressed) Color.Red else Color.Unspecified,
                    contentDescription = "back"
                )
            }

        MyTextView(

            text = title,
            textStyle = MyTextStyle.TitleSemiBold18,
            textColor = MaterialTheme.colorScheme.primaryContainer,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(tvTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )

        if (isMenu)
            IconButton(onClick = onMenuClick, modifier = Modifier.constrainAs(menu) {
                end.linkTo(parent.end, margin = 19.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isMenuPressed = true
                        tryAwaitRelease()
                        isMenuPressed = false
                    })
            }) {
                Icon(
                    painter = painterResource(id = imageRes),
                    tint = if (isMenuPressed) Color.Red else Color.Unspecified,
                    contentDescription = "menu"
                )
            }

    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyToolbar(title = "Edit Profile", R.drawable.ic_edit, true, true, {}, {}, modifier = Modifier)
}
