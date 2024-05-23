package com.example.blackcoffer.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcoffer.ui.theme.appbarcolor

@Composable
fun DropDown(){

    var expanded by remember {
        mutableStateOf(false)
    }

    val menu = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete And Watch",
        "Busy | Do Not Disturb | Will Catch Up Later",
        "SOS | Emergency! Need Assistance! HELP"
    )

    var selectedOption by remember {
        mutableStateOf(menu.get(0))
    }

    var icon = if(expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(
                    width = 1.dp,
                    color = appbarcolor.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                .clickable {
                           expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedOption,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            )

            Icon(imageVector = icon, contentDescription = "icon")
        }

        DropdownMenu(
            modifier = Modifier
                .border(
                    width = 0.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp))
                .height(220.dp)
                .padding( start = 5.dp, end = 5.dp, bottom = 5.dp)
                .fillMaxWidth()

                ,
            expanded = expanded,
            onDismissRequest = { expanded = false },
            ) {
                menu.forEach {option->
                    DropdownMenuItem(
                        text = {
                               Text(text = option , modifier = Modifier.fillMaxWidth())
                        }, onClick = {
                            selectedOption = option
                            expanded = !expanded
                        })
                }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun dropdown(){
    DropDown()
}