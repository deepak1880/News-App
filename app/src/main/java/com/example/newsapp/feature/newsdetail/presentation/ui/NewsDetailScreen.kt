package com.example.newsapp.feature.newsdetail.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.core.ui.HyperlinkText
import com.example.newsapp.core.utils.toSimpleISTFormat
import com.example.newsapp.feature.home.domain.model.Article
import com.example.newsapp.feature.home.presentation.navigation.Screen

@Composable
fun DetailsScreen(
    navController: NavController
) {
    val articles = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("articles")

    if (articles != null) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(articles.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "sample image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = articles.title,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = articles.description.toString(),
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Serif,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )

            Row {
                Text(
                    text = "Author : ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(top = 10.dp)

                )
                Text(
                    text = articles.author,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(top = 10.dp)

                )
            }

            Row {
                Text(
                    text = "Published At : ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(top = 10.dp)

                )
                Text(
                    text = articles.publishedAt.toSimpleISTFormat(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(top = 10.dp)

                )
            }

            Row {
                Text(
                    text = "To Read More : ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(top = 10.dp)

                )
                HyperlinkText(onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("pdfUrl", articles.url)
                    navController.navigate("article_viewer")
                })
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailsScreen() {
    DetailsScreen(rememberNavController())
}
