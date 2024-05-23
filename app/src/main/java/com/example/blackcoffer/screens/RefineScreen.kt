package com.example.blackcoffer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.blackcoffer.ui.theme.appbarcolor
import com.example.blackcoffer.widgets.AppBar
import com.example.blackcoffer.widgets.DropDown
import com.example.blackcoffer.widgets.Slider

@Composable
fun RefineScreen(
  navController : NavHostController
){

    var status by remember {
        mutableStateOf("Hi community! I am open to new connections \uD83D\uDE0A")
    }
    Scaffold(
        topBar = {
           Row (
               modifier = Modifier
                   .fillMaxWidth()
                   .height(45.dp)
                   .background(appbarcolor)
                   .padding(start = 10.dp, end = 20.dp ,top= 5.dp, bottom = 5.dp),
               verticalAlignment = Alignment.CenterVertically,
           ){
               Icon(
                   imageVector = Icons.Default.KeyboardArrowLeft,
                   contentDescription = null,
                   tint = Color.White,
                   modifier = Modifier.size(30.dp)
                       .clickable {
                           navController.popBackStack()
                       }
               )

               Spacer(modifier = Modifier.width(20.dp))
               Text(text = "Refine", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
           }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 20.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 20.dp
                )
        ) {

            Text(
                text = "Select Your Availability",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = appbarcolor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            DropDown()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Add Your Status",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = appbarcolor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp, color = appbarcolor.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(5.dp)
                .height(100.dp)){

                BasicTextField(
                    value = status,
                    onValueChange = {
                        status = it
                    },
                    modifier = Modifier.fillMaxSize())

            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Select Hyper Local Distance",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = appbarcolor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Slider()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Select Purpose",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = appbarcolor
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                PurposeBox(text = "Coffee")
                PurposeBox(text = "Bussiness")
                PurposeBox(text = "Hobbies")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row {
                PurposeBox(text = "Friendship")
                PurposeBox(text = "Movies")
                PurposeBox(text = "Dinning")
            }
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                PurposeBox(text = "Dating")
                PurposeBox(text = "Matrimony")

            }

        }
    }
}
@Composable
fun PurposeBox(
  text : String
){

    var selected by remember {
        mutableStateOf(false)
    }
  Box(
      modifier = Modifier
          .padding(10.dp)
          .border(1.dp, color = appbarcolor, shape = RoundedCornerShape(20.dp))
          .background(if (selected) appbarcolor else Color.White, shape = RoundedCornerShape(20.dp))
          .padding(start = 10.dp, end = 10.dp, top = 6.dp, bottom = 6.dp)
          .clickable {
              selected = !selected
          }){
      Text(
          text = text,
          style = TextStyle(
              color = if(selected) Color.White else appbarcolor
          ))
  }
}


