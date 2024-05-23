package com.example.blackcoffer.navgraph

sealed class Route (
    val route : String
){

    object Explore : Route(
        route = "explore_screen"
    )

    object Refine : Route(
        route = "refine_screen"
    )

    object Service : Route(
        route = "service_screen"
    )

    object Bussiness : Route(
        route = "bussiness_screen"
    )

    object Personal : Route(
        route = "personal_screen"
    )


}