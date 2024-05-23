package com.example.blackcoffer.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.blackcoffer.model.MinFabItem
import com.example.blackcoffer.model.MultiFloatingState
import com.example.blackcoffer.ui.theme.appbarcolor

@Composable
fun MultiFloatingButton(
    multiFloatingState: MultiFloatingState,
    onMultiFloatingStateChange :(MultiFloatingState) -> Unit,
    items : List<MinFabItem>
){

    val transition = updateTransition(targetState = multiFloatingState, label = "transition")
    val rotate by transition.animateFloat(label = "rotate"){
        if(it == MultiFloatingState.Expanded) 345f else 0f
    }

    val fabScale by transition.animateFloat(label = "FabScale") {
        if(it == MultiFloatingState.Expanded) 60f else 0f
    }

    val alpha by transition.animateFloat(
        label = "alpha",
        transitionSpec = { tween(durationMillis = 50) }){
        if(it == MultiFloatingState.Expanded) 1f else 0f
    }

    val textShadow by transition.animateDp(
        label = "textShadow",
        transitionSpec = { tween(durationMillis = 50) }){
        if(it == MultiFloatingState.Expanded) 2.dp else 0.dp
    }

    var backgroundBlur by remember { mutableStateOf(Color.Transparent)}



    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxSize().background(backgroundBlur),
        verticalArrangement = Arrangement.Bottom
    ) {

        if(transition.currentState == MultiFloatingState.Expanded){


                items.forEach {
                    MinFab(
                        item = it,
                        onMinFabItemClick = {

                        },
                        alpha = alpha,
                        textShadow = textShadow,
                        fabScale = fabScale
                    )

                    Spacer(modifier = Modifier.size(40.dp))
                }

        }


        FloatingActionButton(
            onClick = {

                    if(transition.currentState == MultiFloatingState.Expanded){
                        backgroundBlur = Color.Transparent
                        onMultiFloatingStateChange(MultiFloatingState.Collapsed)
                    }else{
                        onMultiFloatingStateChange(MultiFloatingState.Expanded)
                        backgroundBlur = Color.White.copy(alpha=0.8f)

                    }


            },
            modifier = Modifier.rotate(rotate),
            contentColor = Color.White,
            shape = CircleShape,
            containerColor = appbarcolor,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add",
                tint = Color.White,
                modifier = Modifier
                    .rotate(rotate)

            )
        }
    }
}