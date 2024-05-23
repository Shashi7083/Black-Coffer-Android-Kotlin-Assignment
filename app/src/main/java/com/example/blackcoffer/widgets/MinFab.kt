package com.example.blackcoffer.widgets


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcoffer.model.MinFabItem

@Composable
fun MinFab(
    item : MinFabItem,
    alpha:Float,
    textShadow:Dp,
    fabScale:Float,
    showLabel : Boolean = true,
    onMinFabItemClick : (MinFabItem) -> Unit
){

    val buttonColor = Color(0xfff4c249)
    val shadow = Color.Black.copy(alpha= 0.5f)

    Row {

        if(showLabel){
            Text(
                text = item.label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .alpha(
                        animateFloatAsState(
                            targetValue = alpha,
                            animationSpec = tween(50)
                        ).value
                    )
                   // .shadow(textShadow)
                    //.background(MaterialTheme.colorScheme.surface)
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
        Canvas(
            modifier = Modifier
                .size(32.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    onClick = {
                        onMinFabItemClick.invoke(item)
                    },
                    indication = rememberRipple(
                        bounded = false,
                        radius = 20.dp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
        ) {

            drawCircle(
                color = shadow,
                radius = fabScale,
                center = Offset(
                    center.x +2f,
                    center.y + 2f
                )
            )

            drawCircle(
                color = buttonColor,
                radius = 60f
            )

            drawImage(
                image = item.icon,
                topLeft = Offset(
                    center.x - (item.icon.width/2),
                    center.y - (item.icon.width/2),
                ),
                alpha = alpha
            )
        }
    }

}