package com.example.blackcoffer.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.blackcoffer.R
import com.example.blackcoffer.ui.theme.appbarcolor


@Composable
fun NavHeader(){

    ConstraintLayout (
        modifier = Modifier.fillMaxWidth()
    ){
         val (base, setting) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(base) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .height(190.dp)
                .background(appbarcolor)
        ){
             Column(
                 modifier = Modifier
                     .fillMaxHeight()
                     .fillMaxWidth(0.85f)
                     .padding(start = 25.dp, top = 10.dp)
             ) {

                     Image(
                         painter = painterResource(id = R.drawable.profile),
                         contentDescription = "user",
                         modifier = Modifier
                             .size(70.dp)
                             .clip(CircleShape)
                     )

                 Spacer(modifier = Modifier.height(15.dp))

                 Text(text = "Shashi Ranjan Kumar", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)

                 Spacer(modifier = Modifier.height(3.dp))

                 Text(text = "SH8943274793", fontSize = 14.sp, color = Color.White)
                 Spacer(modifier = Modifier.height(8.dp))
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier = Modifier.fillMaxWidth(0.4f)
                 ) {
                     Box(
                         modifier = Modifier
                             .fillMaxWidth()
                             .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                     ) {
                         Box(
                             modifier = Modifier
                                 .height(10.dp)
                                 .fillMaxWidth(0.4f)
                                 .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                         )
                     }
                 }

                 Spacer(modifier = Modifier.height(3.dp))

                 Text(text = "Available", fontSize = 12.sp, color = Color.White)



             }
        }

        Box(
            modifier = Modifier
                .constrainAs(setting){
                    end.linkTo(parent.end, margin = 15.dp)
                    top.linkTo(parent.top)
                },
            contentAlignment = Alignment.Center
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription ="setting",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun header(){
    NavHeader()
}