package com.example.travelapp.ui.features

import android.widget.Space
import com.example.travelapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun SplashScreen(navController: NavController) {

    var splashUrl = R.drawable.explore

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Image(
            painter = rememberCoilPainter(request = splashUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(16.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                )
                .padding(16.dp)
        ) {

            Text(
                text = "Explore\nNew Places",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = (-1).sp
            )

            Text(
                text = "New hotels. Cheap Prices. Wanderlust.",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.1).sp
            )

            Button(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Get Started")

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = ""
                )

            }

        }


    }


}


@Preview
@Composable
fun SplashPreview() {


}