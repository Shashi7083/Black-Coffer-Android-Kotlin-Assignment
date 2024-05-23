package com.example.blackcoffer.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackcoffer.model.User

@Composable
fun Search(
    onSearch:(String) -> Unit
){
    var value by remember {
        mutableStateOf("")
    }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.75f)
            .height(35.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search",
            modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(5.dp))

        Box(modifier = Modifier.fillMaxWidth()){
            if (value.isEmpty()) {
                Text(
                    text = "Search",
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
            BasicTextField(
                value = value,
                onValueChange ={
                    value = it
                    onSearch(it)
                },
                textStyle = TextStyle(
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        }

    }




