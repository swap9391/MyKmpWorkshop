package com.kocfour.mykmpworkshop.ui.components.imageview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kocfour.mykmpworkshop.R

@Composable
fun MyImageView(modifier: Modifier = Modifier, imageRes:Int) {
    Box(modifier) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyImageView(imageRes = R.drawable.img_slider_1)
}