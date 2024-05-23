package com.example.blackcoffer.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PercentageIndicator(
    modifier: Modifier = Modifier,
    filledPercentage: Float,
    rodColor: Color,
    filledColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = rodColor, shape = RoundedCornerShape(8.dp))
        ) {
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(filledPercentage)
                    .background(color = filledColor, shape = RoundedCornerShape(8.dp))
            )
        }
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Profile Score",
            fontSize = 12.sp,
            color = Color.Black.copy(alpha = 0.6f)
        )
        Text(
            text = "- ${(filledPercentage* 100).toInt()}%",
            fontSize = 12.sp,
            color = Color.Black.copy(alpha = 0.6f)
        )
    }

}


