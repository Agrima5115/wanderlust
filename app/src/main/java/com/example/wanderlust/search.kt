package com.example.wanderlust
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.material3.BottomAppBar
import androidx.compose.ui.Alignment
import com.example.wanderlust.ui.theme.WanderlustTheme
import main.example.wanderlust.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(onSearch: (String) -> Unit) {
    val borderColor = if (isSystemInDarkTheme()) {
        Color.Gray
    } else {
        Color.LightGray
    }

    var searchText by remember { mutableStateOf("Search") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        label = { Text("Search") },
        shape = MaterialTheme.shapes.medium,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onSearch(searchText)
                }
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            cursorColor = MaterialTheme.colorScheme.onSurface,
//            textColor = MaterialTheme.colorScheme.onSurface
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun NearBySection() {
    val images = listOf(
        R.drawable.place4,
        R.drawable.place6,
        R.drawable.place3
    )

    Column {
        Text(text = "Nearby", style = MaterialTheme.typography.titleLarge)
        LazyRow(content = {
            items(images.size) { index ->
                Image(
                    painter = painterResource(id = images[index]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .padding(8.dp)
                )
            }
        })
    }
}


@Composable
fun RecentSearchSection(navToPlaceDetail: () -> Unit) {
    Column {
        Text(text = "Recent Search", style = MaterialTheme.typography.titleLarge)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            PlaceCard(
                modifier = Modifier.weight(1f),
                name = "China",
                location = "Hong Kong",
                image = R.drawable.place1,
                onClick = navToPlaceDetail
            )
            Spacer(modifier = Modifier.width(16.dp))
            PlaceCard(
                modifier = Modifier.weight(1f),
                name = "Singapore",
                location = "Marina Bay",
                image = R.drawable.place2,
                onClick = navToPlaceDetail
            )
        }
    }
}

@Composable
fun PopularSection() {
    Column {
        Text(text = "Recommended", style = MaterialTheme.typography.titleLarge)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.place3),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.place4),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
fun PlaceCard(
    modifier: Modifier = Modifier,
    name: String,
    location: String,
    image: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(8.dp) // Add padding for spacing
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(4f), // Set elevation using zIndex
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_pin), // Use your custom pin icon
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary, // Adjust the color as needed
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = location, style = MaterialTheme.typography.bodyLarge)
                    }
                    Text(text = name, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}

@Composable
fun SearchResults(results: List<String>) {
    if (results.isNotEmpty()) {
        Column {
            Text(text = "Search Results", style = MaterialTheme.typography.titleLarge)
            results.forEach { result ->
                Text(text = result, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    pressBack: () -> Unit,
    navToPlaceDetail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val searchResults by remember { mutableStateOf(mutableListOf<String>()) }

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
            .verticalScroll(state = scrollState)
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = pressBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            title = { Text("Wanderlust") },
            actions = {
                // Add a bookmark icon
                IconButton(
                    onClick = {
                        // Handle bookmark icon click here
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = null
                    )
                }
            }
        )
        SearchField { query ->
            // Perform search and update searchResults
            searchResults.clear()
            searchResults.addAll(listOf("Result 1", "Result 2", "Result 3")) // Simulated results
        }
        SearchResults(searchResults)
        NearBySection()
        RecentSearchSection(navToPlaceDetail)
        PopularSection()
    }
//    Spacer(modifier = Modifier.weight(1f))
//    Box(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        BottomAppBar(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 16.dp, bottom = 5.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = { /* Navigate to HomeScreen */ }) {
//                    Icon(
//                        imageVector = Icons.Default.Home,
//                        contentDescription = "Home",
//                        tint = Color.Unspecified
//                    )
//                }
//                IconButton(onClick = { /* Navigate to Search */ }) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search",
//                        tint = Color.Unspecified
//                    )
//                }
//                IconButton(onClick = { /* Navigate to Bookmark */ }) {
//                    Icon(
//                        imageVector = Icons.Default.Bookmark,
//                        contentDescription = "Bookmark",
//                        tint = Color.Unspecified
//                    )
//                }
//                IconButton(onClick = { /* Navigate to Profile */ }) {
//                    Icon(
//                        imageVector = Icons.Default.AccountCircle,
//                        contentDescription = "Profile",
//                        tint = Color.Unspecified
//                    )
//                }
//            }
//        }
//    }
}



@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val searchResults = listOf("Result 1", "Result 2", "Result 3")
    WanderlustTheme {
        Search(
            pressBack = {},
            navToPlaceDetail = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}