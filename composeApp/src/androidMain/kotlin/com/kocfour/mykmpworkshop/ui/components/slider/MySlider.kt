package com.kocfour.mykmpworkshop.ui.components.slider

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.scale
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
    var kkSliderValue by remember { mutableFloatStateOf(value) }

    Column(modifier = modifier) {
        Slider(
            value = kkSliderValue,
            onValueChangeFinished = {
                currentSliderValue.invoke(kkSliderValue.roundToInt())
            },
            onValueChange = {
                kkSliderValue = it

            },
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    colors = SliderDefaults.colors(MaterialTheme.colorScheme.primaryContainer),
                    thumbSize = DpSize(28.dp, 28.dp)
                )

            },
            track = {
                SliderDefaults.Track(
                    it,

                    colors = SliderDefaults.colors(
                        activeTickColor = Color.Transparent,
                        inactiveTickColor = Color.Transparent,
                        activeTrackColor = ColorLightPrimaryBlue,
                        inactiveTrackColor = ColorSecondaryText
                    ),
                    modifier = Modifier
                        .scale(1f, 2f)
                )
            },
            steps = 100,
            valueRange = range,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(), // Add horizontal padding
            horizontalArrangement = Arrangement.SpaceBetween // Space between texts
        ) {
            MyTextView(text = 0.toString(), textStyle = MyTextStyle.TitleMedium14)
            MyTextView(text = 100.toString(), textStyle = MyTextStyle.TitleMedium14)
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
        range = 0f..100f,{}
    )
}
