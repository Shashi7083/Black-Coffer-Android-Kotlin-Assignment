package com.example.blackcoffer.screens.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.blackcoffer.R
import com.example.blackcoffer.model.users
import com.example.blackcoffer.widgets.Search
import com.example.blackcoffer.widgets.UserCard

@Composable
fun ServiceScreen(
    navController : NavHostController
){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Search(){search->
//                filteredUsers = users.filter { user ->
//                    user.name?.contains(search , ignoreCase = true) == true || user.city?.contains(search, ignoreCase = true) == true
//                }
            }
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "filter",
                modifier = Modifier.size(35.dp))
        }


    }
}