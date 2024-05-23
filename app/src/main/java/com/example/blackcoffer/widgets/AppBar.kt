package com.example.blackcoffer.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.blackcoffer.R
import com.example.blackcoffer.navgraph.Route
import com.example.blackcoffer.ui.theme.appbarcolor


@Composable
fun AppBar(
    navController: NavHostController,
    onHamClick:(Boolean) ->Unit
){

    var openDrawer by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(appbarcolor)
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            painter = painterResource(id = R.drawable.hamburger,),
            contentDescription = "hamburger",
            modifier = Modifier.size(30.dp)
                .clickable {
                    openDrawer = !openDrawer
                    onHamClick(openDrawer)
                }
        )

        Spacer(modifier = Modifier.width(20.dp))
        Column (
            modifier = Modifier.fillMaxHeight(),
           verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "Shashi Ranjan Kumar !!", style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 15.sp
            ))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "location",
                    modifier = Modifier.size(14.dp),
                    tint = Color.White)

                Text(text = "Shivdhara, Darbhanga", color = Color.White, fontSize = 12.sp)

            }
        }

        Spacer(modifier = Modifier.fillMaxWidth(0.8f))
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                navController.navigate(Route.Refine.route){
                    popUpTo(Route.Refine.route){
                        inclusive = true
                    }
                }
            }
        ){
            Image(painter = painterResource(id = R.drawable.refine), contentDescription = "")
            Text(text = "Refine", style = TextStyle(
                fontSize = 12.sp,
                color = Color.White
            ))
        }

    }
}


