package com.example.blackcoffer.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.blackcoffer.screens.ExploreScreen
import com.example.blackcoffer.screens.RefineScreen
import com.example.blackcoffer.screens.tabs.BussinesseScreen
import com.example.blackcoffer.screens.tabs.PersonalScreen
import com.example.blackcoffer.screens.tabs.ServiceScreen


@Composable
fun NavGraph(

){

  val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Explore.route){

        composable(
            route = Route.Explore.route
        ){
            ExploreScreen(
                navController = navController
            )
        }

        composable(
            route = Route.Refine.route
        ){
            RefineScreen(navController = navController)
        }

        composable(
            route = Route.Personal.route
        ){
            PersonalScreen(navController = navController)
        }

        composable(
            route = Route.Service.route
        ){
            ServiceScreen(navController = navController)
        }

        composable(
            route = Route.Bussiness.route
        ){
            BussinesseScreen(navController = navController)
        }

    }

}