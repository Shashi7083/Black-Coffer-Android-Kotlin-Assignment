package com.example.blackcoffer.screens.tabs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
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
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.example.blackcoffer.model.MinFabItem
import com.example.blackcoffer.model.MultiFloatingState
import com.example.blackcoffer.widgets.MultiFloatingButton

@Composable
fun PersonalScreen(
    navController : NavHostController
){
    var filteredUsers by remember { mutableStateOf(users) }
    var shouldShowButton by remember { mutableStateOf(true) }
    val listState = remember { LazyListState() }
    val threshold = 100 // Hide FAB after scrolling down 100 pixels
    var previousFirstVisibleItem by remember { mutableStateOf(0) }

    var multiFloatingState by remember {
        mutableStateOf(MultiFloatingState.Collapsed)
    }

    val items = listOf(
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.dating),
            label = "Dating",
            identifier = "datingFab"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.rings),
            label = "Matrimony",
            identifier = "MatrimonyFab"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.bag1),
            label = "Buy-Sell-Rent",
            identifier = "Buy-Sell"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.card),
            label = "Matrimony",
            identifier = "MatrimonyFab"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.hash),
            label = "Matrimony",
            identifier = "MatrimonyFab"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.bag),
            label = "Matrimony",
            identifier = "MatrimonyFab"
        ),
        MinFabItem(
            icon = ImageBitmap.imageResource(id = R.drawable.edit),
            label = "Matrimony",
            identifier = "MatrimonyFab"
        )

    )


   Scaffold (
       floatingActionButton = {
           AnimatedVisibility(
               visible = shouldShowButton,
               enter = fadeIn(),
               exit = fadeOut()
           ) {
               MultiFloatingButton(multiFloatingState = multiFloatingState,
                   onMultiFloatingStateChange = {
                                                multiFloatingState = it
                   },
                   items = items)
           }
       }
      /* floatingActionButton = {
           AnimatedVisibility(
               visible = shouldShowButton,
               enter = fadeIn(),
               exit = fadeOut()
           ) {
               FloatingActionButton(
                   onClick = {

                   },
                   contentColor = Color.White,
                   shape = CircleShape,
                   containerColor = appbarcolor,
                   modifier = Modifier
                       .padding(16.dp)

               ) {
                   Icon(
                       imageVector = Icons.Default.Add,
                       contentDescription = "add",
                       tint = Color.White,
                       modifier = Modifier

                   )
               }
           }
       }*/
   ){
       Column(
           modifier = Modifier
               .padding(it)
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
                   filteredUsers = users.filter { user ->
                       user.name?.contains(search , ignoreCase = true) == true || user.city?.contains(search, ignoreCase = true) == true
                   }
               }
               Image(
                   painter = painterResource(id = R.drawable.filter),
                   contentDescription = "filter",
                   modifier = Modifier.size(35.dp))
           }

           LazyColumn (
               state = listState
           ){
               items(filteredUsers){user->
                   UserCard(user = user)


                   //using pixel
//                   if (listState.firstVisibleItemScrollOffset > threshold) {
//                       shouldShowButton = false
//                   } else {
//                       shouldShowButton = true
//                   }

                   // Update FAB visibility based on scroll direction
                   val currentFirstVisibleItem = listState.firstVisibleItemIndex
                   if (currentFirstVisibleItem > previousFirstVisibleItem) {
                       // Scrolling down - Hide FAB
                       shouldShowButton = false
                   } else if (currentFirstVisibleItem < previousFirstVisibleItem) {
                       // Scrolling up - Show FAB
                       shouldShowButton = true
                   }

                   // Update previousFirstVisibleItem for next iteration
                   previousFirstVisibleItem = currentFirstVisibleItem

               }
           }



       }
   }
    

}

