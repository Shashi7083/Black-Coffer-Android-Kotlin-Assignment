package com.example.blackcoffer.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.blackcoffer.R
import com.example.blackcoffer.model.DrawerItem
import com.example.blackcoffer.screens.tabs.PersonalScreen
import com.example.blackcoffer.screens.tabs.ServiceScreen
import com.example.blackcoffer.screens.tabs.BussinesseScreen
import com.example.blackcoffer.ui.theme.appbarcolor
import com.example.blackcoffer.widgets.AppBar
import com.example.blackcoffer.widgets.NavHeader
import kotlinx.coroutines.launch

val items = listOf(
    DrawerItem(
        title = "My Profile",
    ),
    DrawerItem(
        title = "My Network",
        selectedIcon = R.drawable.network,
        unSelectedIcon = R.drawable.network
    ),
    DrawerItem(
        title="Switch to Service",
        selectedIcon = R.drawable.service,
        unSelectedIcon = R.drawable.service
    ),
    DrawerItem(
        title = "Switch to Businesses",
        selectedIcon = R.drawable.bussiness,
        unSelectedIcon = R.drawable.bussiness
    ),
    DrawerItem(
        title = "Dating",
        selectedIcon = R.drawable.dating1,
        unSelectedIcon = R.drawable.dating1
    ),

    )

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(
 navController: NavHostController
){

    
    val context  = LocalContext.current


    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {ExploreTab.entries.size})
    var selectedTabIndex = remember {
        derivedStateOf { pagerState.currentPage }
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)



    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier.fillMaxWidth(0.7f)
            ){

                Column {
                    NavHeader()
                    
                    items.forEach { 
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                            .padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                            ){
                            Image(painter = painterResource(id = it.unSelectedIcon), contentDescription = "")
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = it.title)
                        }
                    }
                }
                
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                AppBar(
                    navController = navController
                ){openDrawer->
//                    Toast.makeText(context, "${openDrawer}", Toast.LENGTH_SHORT).show()
                    scope.launch {
                       drawerState.open()
                    }
                }
            },
        ) {
            Column(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex.value,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = appbarcolor,
                    contentColor = Color.White,
//                indicator = {tabPositions->
//                    if (selectedTabIndex.value < tabPositions.size) {
//                        TabRowDefaults.Indicator(
//                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
//                            color = Color.White
//
//                        )
//                    }
//                }
                ) {
                    ExploreTab.entries.forEachIndexed { index, currentTab ->

                        Tab(
                            selected = selectedTabIndex.value == index,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(currentTab.ordinal)
                                }
                            },
                            text = {
                                Text(
                                    text = currentTab.text
                                )
                            }
                        )
                    }
                }
                HorizontalPager(state = pagerState) {page ->
                    when(page){

                        0-> PersonalScreen(
                            navController = navController
                        )
                        1-> ServiceScreen(
                            navController = navController
                        )
                        2-> BussinesseScreen(
                            navController = navController
                        )
                    }
                }
            }
        }


    }






}

enum class ExploreTab(
    val text : String
){
     Personal(
         text = "Personal"
     ),
    Service(
        text = "Services"
    ),
    Bussiness(
        text = "Bussinesses"
    )
}


