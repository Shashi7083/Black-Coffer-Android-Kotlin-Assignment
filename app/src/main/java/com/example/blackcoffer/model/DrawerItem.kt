package com.example.blackcoffer.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.blackcoffer.R

data class DrawerItem(
    val title: String,
    val route : String= "",
    val selectedIcon : Int = R.drawable.person,
    val unSelectedIcon : Int = R.drawable.person
)
