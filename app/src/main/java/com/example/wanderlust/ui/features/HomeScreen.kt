package com.example.travelapp.ui.features

import com.example.travelapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navController: NavController) {


    LazyColumn(modifier = Modifier.fillMaxWidth()) {


        item {
            HomeHeader()
        }

        item {
            Text(
                text = "THAI WEEK SPECIAL",
                color = Color.Black,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 16.dp,
                    bottom = 16.dp
                ),
            )
        }

        itemsIndexed(tripListing) { position, data ->
            HomeTripItem(homeTripModel = data,navController = navController)
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

    }

}


@Composable
@Preview
fun HomeHeader() {

    val homeHeaderBg = R.drawable.gradient

    Box {

        Image(
            painter = rememberCoilPainter(request = homeHeaderBg, fadeIn = true),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .alpha(0.2f)
                .fillMaxWidth()
        )


        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .statusBarsPadding()
                .padding(16.dp)
        ) {

            Text(
                text = "Hello, Wanderer!",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                letterSpacing = (-1).sp
            )

            Text(
                text = "Yindī t̂xnrạb s̄ū̀ pratheṣ̄thịy?",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = ((-0.2).sp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {


                VerticalButton(vector = Icons.Filled.AirplanemodeActive, text = "Flights")
                VerticalButton(vector = Icons.Filled.DirectionsCar, text = "Cars")
                VerticalButton(vector = Icons.Filled.Business, text = "Hotel")
                VerticalButton(vector = Icons.Filled.LocalShipping, text = "Cruise")

            }


        }


    }

}

@Composable
fun VerticalButton(vector: ImageVector, text: String) {

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                imageVector = vector, contentDescription = ""
            )

            Text(text = text)

            Spacer(modifier = Modifier.height(8.dp))

        }


    }

}

data class HomeTripModel(
    val image: Int,
    val dayPerson: String,
    val title: String,
    val rating: Float
)

@Composable
fun HomeTripItem(homeTripModel: HomeTripModel,navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Image(
            painter = rememberCoilPainter(request = homeTripModel.image, fadeIn = true),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate("detail")
                }
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row() {

            Text(
                text = homeTripModel.dayPerson,
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color(255, 215, 0),
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
                    .align(CenterVertically)
            )

            Text(
                text = homeTripModel.rating.toString(),
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }

        Text(
            text = homeTripModel.title,
            fontFamily = OverPassFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        )

    }


}

val tripListing = listOf<HomeTripModel>(
    HomeTripModel(
        R.drawable.thailand,
        "5 Days / 2 Person",
        "View to wander about Thailand!",
        4.8f
    ),

    HomeTripModel(
        R.drawable.kanchanaburi,
        "5 Days / 2 Person",
        "You cannot miss this place before Leaving Thailand",
        4.7f
    ),

    HomeTripModel(
        R.drawable.ayutthaya,
        "5 Days / 2 Person",
        "This is the Holiest place in Thailand",
        4.8f
    ),

    HomeTripModel(
        R.drawable.khaosok,
        "5 Days / 2 Person",
        "What is so special in the Southern Thailand?",
        4.6f
    ),
    )