package com.kocfour.mykmpworkshop.ui.components.slider

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.ColorLightPrimaryBlue
import com.kocfour.mykmpworkshop.ui.theme.ColorSecondaryText
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySlider(
    modifier: Modifier,
    value: Float = 0f,
    range: ClosedFloatingPointRange<Float>,
    currentSliderValue: ((Int) -> Unit),
) {
    var sliderValue by remember { mutableFloatStateOf(value) }

    Column(modifier = modifier) {
        Slider(
            value = sliderValue,
            onValueChangeFinished = {
                currentSliderValue.invoke(sliderValue.roundToInt())
            },
            onValueChange = {
                sliderValue = it
                currentSliderValue.invoke(sliderValue.roundToInt())
            },
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    colors = SliderDefaults.colors(MaterialTheme.colorScheme.primaryContainer),
                    thumbSize = DpSize(22.dp, 22.dp)
                )

            },
            track = {
                SliderDefaults.Track(
                    it,
                    modifier = Modifier.height(12.dp),
                    drawStopIndicator = null,
                    colors = SliderDefaults.colors(
                        activeTickColor = Color.Transparent,
                        inactiveTickColor = Color.Transparent,
                        activeTrackColor = ColorLightPrimaryBlue,
                        inactiveTrackColor = ColorSecondaryText
                    )
                )
            },
            steps = range.endInclusive.toInt(),
            valueRange = range,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(), // Add horizontal padding
            horizontalArrangement = Arrangement.SpaceBetween // Space between texts
        ) {
            MyTextView(text = 0.toString(), textStyle = MyTextStyle.TitleMedium14)
            MyTextView(text = range.endInclusive.toInt().toString(), textStyle = MyTextStyle.TitleMedium14)
        }

        // Text(text = sliderPosition.toString())
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MySlider(
        modifier = Modifier,
        value = 50f,
        range = 0f..200f, {}
    )
}
