package com.example.newsapp.feature.home.presentation


import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.feature.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController,viewModel: HomeViewModel = viewModel()) {

    val newList = viewModel.newList
    val loading = viewModel.isLoading

    //Make loading as common component
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn {
            items(newList) { article ->
                Column(modifier = Modifier
                    .padding(15.dp, 10.dp, 15.dp, 0.dp)
                    .clickable{
                        val encodedTitle = Uri.encode(article.title)
                        val encodedImage = Uri.encode(article.urlToImage)
                        val encodedDescription = Uri.encode(article.description)
                        val encodedAuthor = Uri.encode(article.author)
                        val encodedContent = Uri.encode(article.content)
                        val encodedUrl = Uri.encode(article.url)
                        val encodedPublishAt = Uri.encode(article.publishedAt)


                        navController.navigate("details_screen/$encodedTitle/$encodedDescription/$encodedAuthor/$encodedImage/$encodedContent/$encodedPublishAt/$encodedUrl")
                    }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(article.urlToImage)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Article Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                    )
                    Text(
                        text = article.title ?: "No Title",
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 18.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(0.dp, 5.dp, 0.dp, 0.dp),
                        text = article.description ?: "No Description",
                        style = MaterialTheme.typography.bodySmall,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Normal,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider()
                }
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen(navController = rememberNavController())
}