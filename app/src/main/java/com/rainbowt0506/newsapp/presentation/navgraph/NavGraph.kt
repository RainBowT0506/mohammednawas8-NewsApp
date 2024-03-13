package com.rainbowt0506.newsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.rainbowt0506.newsapp.presentation.bookmark.BookmarkScreen
import com.rainbowt0506.newsapp.presentation.bookmark.BookmarkViewModel
import com.rainbowt0506.newsapp.presentation.home.HomeScreen
import com.rainbowt0506.newsapp.presentation.home.HomeViewModel
import com.rainbowt0506.newsapp.presentation.news_navigator.NewsNavigator
import com.rainbowt0506.newsapp.presentation.onboarding.OnBoardingScreen
import com.rainbowt0506.newsapp.presentation.onboarding.OnBoardingViewModel
import com.rainbowt0506.newsapp.presentation.search.SearchScreen
import com.rainbowt0506.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewMode: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewMode::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                NewsNavigator()
            }
        }
    }

}