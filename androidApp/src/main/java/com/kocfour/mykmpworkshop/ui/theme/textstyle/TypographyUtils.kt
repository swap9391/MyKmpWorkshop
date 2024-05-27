package com.kocfour.mykmpworkshop.ui.theme.textstyle

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.kocfour.mykmpworkshop.android.R
import com.kocfour.mykmpworkshop.ui.theme.PrimaryTextColor
import com.kocfour.mykmpworkshop.ui.theme.WhiteColor


class TypographyUtils {
    companion object {

        /**
         * The font family used in entire KKTextViewComponent
         */
        val MyFontFamily = FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_light, FontWeight.Light),
            Font(R.font.poppins_bold, FontWeight.Bold),
            Font(R.font.poppins_semi_bold, FontWeight.SemiBold)
            )


        /**
         * The getKKTextStyle function is used to return the TextStyle based on KKTextStyle.
         * @param kkFontStyle The kkFontStyle is having multiple possible values. e.g XLargeTitle, LargeTitle, Title1, Title2 etc. Default is KKTextStyle.Title1
         */
        fun getKKTextStyle(kkFontStyle: MyTextStyle): TextStyle {
            when (kkFontStyle) {

                MyTextStyle.Headline -> return TextStyle(
                    fontSize = 17.sp,
                    color = WhiteColor,
                    lineHeight = TextUnit(25f, TextUnitType.Sp)
                )

                MyTextStyle.Title1 -> return TextStyle(
                    fontSize = 28.sp,
                    color = WhiteColor,
                    letterSpacing = TextUnit(-0.3F, TextUnitType.Sp),
                    lineHeight = TextUnit(40f, TextUnitType.Sp)
                )
                MyTextStyle.Title2 -> return TextStyle(
                    fontSize = 14.sp,
                    color = WhiteColor,
                    letterSpacing = TextUnit(-0.3F, TextUnitType.Sp),
                    lineHeight = TextUnit(20f, TextUnitType.Sp)
                )
                MyTextStyle.Title3 -> return TextStyle(
                    fontSize = 20.sp,
                    color = WhiteColor,
                    lineHeight = TextUnit(28f, TextUnitType.Sp)
                )

                MyTextStyle.Body -> return TextStyle(
                    fontSize = 17.sp,
                    color = WhiteColor,
                    letterSpacing = TextUnit(-0.7F, TextUnitType.Sp),
                    lineHeight = TextUnit(25f, TextUnitType.Sp)
                )

                MyTextStyle.LargeText -> return TextStyle(
                    fontSize = 20.sp,
                    color = WhiteColor,
                    letterSpacing = TextUnit(-0.7F, TextUnitType.Sp),
                    lineHeight = TextUnit(32.0F, TextUnitType.Sp)
                )
                MyTextStyle.XLargeText -> return TextStyle(
                    fontSize = 28.sp,
                    color = Color.Black,
                    letterSpacing = TextUnit(-0.7F, TextUnitType.Sp),
                    lineHeight = TextUnit(26.14F, TextUnitType.Sp)
                )

                MyTextStyle.XLargeTextWhite -> return TextStyle(
                    fontSize = 28.sp,
                    color = WhiteColor,
                    letterSpacing = TextUnit(-0.7F, TextUnitType.Sp),
                    lineHeight = TextUnit(26.14F, TextUnitType.Sp)
                )
            }
        }
    }
}
