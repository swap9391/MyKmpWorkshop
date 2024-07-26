package com.kocfour.mykmpworkshop.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.theme.PrimaryBlueTextColor

@Composable
fun IndicatorDots(currentPage: Int, totalPages: Int) {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i in 0 until totalPages) {
            Box(
                modifier = Modifier
                    .height(6.dp)
                    .width(20.dp)
                    .clip(RoundedCornerShape(50))
                    .background(if (i == currentPage) PrimaryBlueTextColor else Color.LightGray)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    IndicatorDots(1,3)
}