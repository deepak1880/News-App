package com.example.newsapp.util

fun String.extractDate(): String {
    return this.split("T").firstOrNull() ?: ""
}
