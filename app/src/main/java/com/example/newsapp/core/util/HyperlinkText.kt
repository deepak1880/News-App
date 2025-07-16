package com.example.newsapp.core.util

import androidx.compose.foundation.clickable
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HyperlinkText(
    text: String = "Click here",
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(
        text = text,
        color = Color.Blue,s
        fontSize = 16.sp,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        modifier = modifier
            .padding(top = 10.dp)
            .clickable { onClick() }
    )
}

