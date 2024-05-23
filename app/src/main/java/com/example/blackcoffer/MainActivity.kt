package com.example.blackcoffer

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import com.example.blackcoffer.navgraph.NavGraph
import com.example.blackcoffer.screens.ExploreScreen
import com.example.blackcoffer.screens.tabs.PersonalScreen
import com.example.blackcoffer.ui.theme.BlackCofferTheme
import com.example.blackcoffer.ui.theme.appbarcolor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



                val view = LocalView.current
                val window = (view.context as Activity).window
                window.statusBarColor = Color(0xff0E2E43).toArgb()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                        NavGraph()
                }
            }

    }
}

