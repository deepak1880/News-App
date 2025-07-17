package com.example.newsapp.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

//Converts the ISO 8601 date format into IST
//   example:
//   input = "2025-07-08T06:47:10Z"
//   Output: 08-07-2025 12:17:10
fun String.toSimpleISTFormat(): String {
    val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    isoFormat.timeZone = TimeZone.getTimeZone("UTC")

    val outputFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    outputFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

    val date = isoFormat.parse(this)
    return outputFormat.format(date ?: Date())
}