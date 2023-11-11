package com.example.wanderlust

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun VisitedCountry(navController: NavController)
{
    val Japan = painterResource(R.drawable.japan)
    val USA = painterResource(R.drawable.usa)
    val UK = painterResource(R.drawable.uk)
    val Australia = painterResource(R.drawable.australia)

    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(30.dp)
                )
            }

            // Heading "Visited Country"
            Text(
                text = "Visited Country",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp) // Adjust the start padding as needed
            )
        }
        Spacer(modifier = Modifier.height(45.dp))
        // Card 1

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = Japan,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Japan",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card 2
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(45.dp),
                    painter = Australia,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Australia     ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card 3
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = UK,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Unite Kingdom ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Card 4
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))

        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = USA,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "USA        ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


            }
        }
    }

}
