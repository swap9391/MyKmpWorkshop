package com.kocfour.mykmpworkshop.ui.theme.textstyle

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kocfour.mykmpworkshop.R


class TypographyUtils {
    companion object {

        val MyFontFamily = FontFamily(
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_bold, FontWeight.Bold),
            Font(R.font.poppins_semi_bold, FontWeight.SemiBold)
            )


        fun getMyTextStyle(myFontStyle: MyTextStyle): TextStyle {
            when (myFontStyle) {

                MyTextStyle.TitleMedium12 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                MyTextStyle.TitleMedium14 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium16 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium18 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleMedium20 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )

                MyTextStyle.TitleLight10 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight12 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight14 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight16 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight18 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight20 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleLight36 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Light,
                )

                MyTextStyle.TitleBold12 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold14 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold16 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold18 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold20 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold22 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleBold24 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )

                MyTextStyle.TitleSemiBold12 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold14 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold16 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold18 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                MyTextStyle.TitleSemiBold20 -> return TextStyle(
                    fontFamily = MyFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}
