package com.kocfour.mykmpworkshop.ui.screens.usermanagement

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kocfour.mykmpworkshop.R
import com.kocfour.mykmpworkshop.android.AppConstants
import com.kocfour.mykmpworkshop.ui.components.textView.MyTextView
import com.kocfour.mykmpworkshop.ui.theme.WhiteColor
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import kotlinx.coroutines.delay


@Composable
 fun MySplashScreen(navHostController: NavHostController){

     val scale = remember {
         Animatable(0f)
     }

     LaunchedEffect(key1 = true) {
         scale.animateTo(
             targetValue = 0.6f,
             animationSpec = tween(
                 durationMillis = 1000,
                 easing = {
                     OvershootInterpolator(4f).getInterpolation(it)
                 })
         )

         delay(1500L)

         navHostController.navigate(AppConstants.KEY_NAVIGATE_ONBOARDING){
             popUpTo(AppConstants.KEY_NAVIGATE_SPLASH){
                 inclusive = true
             }
         }
     }



     ConstraintLayout(modifier = Modifier
         .fillMaxSize()
         .paint(
             painterResource(id = R.drawable.img_splash_screen_background),
             contentScale = ContentScale.FillBounds
         )){

         val (blueDrop, whiteDrop,text) = createRefs()


         Image(
            modifier = Modifier.wrapContentSize()
                .constrainAs(blueDrop){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(id = R.drawable.img_splash_water_drop_blue),
            contentDescription = "WaterDrop Blue")

         Image(
             modifier = Modifier.padding(bottom = 45.dp, start = 15.dp)
                 .width(157.dp)
                 .height(171.dp).constrainAs(whiteDrop){
                     bottom.linkTo(text.top)
                     start.linkTo(parent.start)
                     end.linkTo(parent.end)
                 },
             painter = painterResource(id = R.drawable.ic_spash_drops),
             contentDescription = "WaterDrop Blue")

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.constrainAs(text){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(blueDrop.bottom)
        }){
            MyTextView(text = stringResource(id = R.string.text_drop_water_tracker), textStyle = MyTextStyle.TitleBold24, textColor = WhiteColor)
            MyTextView(text = stringResource(id = R.string.text_drop_water_tracker_subtitle),
                textStyle = MyTextStyle.TitleMedium14, textAlign = TextAlign.Center, textColor = WhiteColor,
                modifier = Modifier
                    .alpha(0.7f)
                    .padding(start = 80.dp, end = 80.dp))
          }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    MySplashScreen(navHostController = navController)
}