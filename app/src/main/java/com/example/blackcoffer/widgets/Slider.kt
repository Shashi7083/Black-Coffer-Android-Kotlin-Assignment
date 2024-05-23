package com.example.blackcoffer.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.blackcoffer.ui.theme.appbarcolor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Slider(){

    var sliderPosition by remember { mutableStateOf(1f) }
    Column(modifier = Modifier.fillMaxWidth()) {

        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                            },
            valueRange = 1f..100f,
            colors = SliderDefaults.colors(
                thumbColor = appbarcolor,
                activeTrackColor = appbarcolor),
            thumb = {
                ConstraintLayout(
                    modifier = Modifier.size(50.dp)
                ){
                    val (mark, label) = createRefs()
                    Box(modifier = Modifier
                        .constrainAs(mark) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .size(15.dp)
                        .background(appbarcolor, shape = CircleShape)
                    )

                    Box(
                        modifier = Modifier
                            .constrainAs(label){
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                top.linkTo(parent.top , margin = -10.dp)
                            }
                            .height(25.dp)
                            .width(30.dp)
                            .background(appbarcolor),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = " "+sliderPosition.toInt().toString()+"  ",
                            color = Color.White
                        )
                    }
                }
            }
        )


        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "1 Km" , fontSize = 12.sp)
            Text(text = "100 Km" , fontSize = 12.sp)

        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun slider(){
    Slider()
}