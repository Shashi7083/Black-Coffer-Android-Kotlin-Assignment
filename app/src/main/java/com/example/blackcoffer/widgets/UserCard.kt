package com.example.blackcoffer.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.blackcoffer.R
import com.example.blackcoffer.model.User
import com.example.blackcoffer.model.users
import com.example.blackcoffer.ui.theme.appbarcolor
import com.example.blackcoffer.ui.theme.bussiness
import com.example.blackcoffer.ui.theme.coffee
import com.example.blackcoffer.ui.theme.friendship
import com.example.blackcoffer.ui.theme.profilebg


@Composable
fun UserCard(
   user: User
){


 var request by remember {
     mutableStateOf("INVITE")
 }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.3f)
            .padding(start = 10.dp, end = 10.dp, top = 20.dp)
    ) {
        val (element1, element2) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(element1) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth(0.88f)
                .fillMaxHeight()
                .border(
                    1.dp,
                    color = Color.Gray.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(20.dp)
                ),


        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, end = 15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 70.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                            Text(
                                text = user?.name!!,
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                            )
                        Text(
                            text = if(request.equals("INVITE") )"+ "+request else "PENDING",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = if(request.equals("INVITE")) appbarcolor else Color.Gray
                            ),
                            modifier = Modifier.clickable {
                                user?.request = "PENDING"
                                if(request.equals("INVITE")){
                                    request = "PENDING"
                                }else{
                                    request = "INVITE"
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = user?.city!!,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = Color.Black.copy(alpha = 0.8f)
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "|", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = user?.profession!!,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = Color.Black.copy(alpha = 0.8f)
                            )
                        )

                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Within "+user?.distance!!,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    PercentageIndicator(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(10.dp)
                            .border(1.dp, color = appbarcolor, shape = RoundedCornerShape(8.dp)),
                        filledPercentage = 0.3f,
                        rodColor = Color.Gray,
                        filledColor = appbarcolor
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, bottom = 20.dp)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(0.9f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        AddPurpose(R.drawable.coffee,"Coffee", color = coffee)

                        Text(text = "|", fontWeight = FontWeight.Bold, fontSize = 16.sp)

                        AddPurpose(img = R.drawable.briefcase, s = "Bussiness", color = bussiness)

                        Text(text = "|", fontWeight = FontWeight.Bold, fontSize = 16.sp)

                        AddPurpose(img = R.drawable.users, s = "Friendship", color = friendship)

                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = user.status.toString(),
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = appbarcolor.copy(alpha = 0.8f),
                            fontSize = 16.sp
                        )
                        )
                }
            }
        }

        Box(
            modifier = Modifier
                .constrainAs(element2) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = -0.5f.dp)

                }
                .size(100.dp)
                .border(width = 0.dp, color = Color.Gray, shape = RoundedCornerShape(20.dp))
                .background(profilebg, shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ){
                Text(
                    text = Initials(fullName = user.name),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = appbarcolor
                    )
                )
        }
    }
}


@Composable
fun AddPurpose(img: Int, s: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(img),
            contentDescription = "coffee",
            modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = s,
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )
    }
}

fun Initials(
    fullName : String?
):String {

    val initials = fullName?.split(" ")
        ?.take(2) // Take the first two words
        ?.map { it.first() } // Extract the first character of each word
        ?.joinToString("") // Join the characters into a single string
        ?.toUpperCase() // Convert the initials to uppercase
    return initials.toString()
}


