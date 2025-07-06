package com.example.newsapp

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationBarScreen(navController: NavController) {

    val selectedBottomNav = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        contentColor = Color.White
    ) {
        navigationBarItem.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedBottomNav.intValue == index,
                onClick = {
                    selectedBottomNav.intValue = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = if (index == selectedBottomNav.intValue) MySelectedIconColor else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MySelectedIconColor,
                    indicatorColor = MyIndicatorColor
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewNavigationBarScreen(){
    NavigationBarScreen(rememberNavController())
}