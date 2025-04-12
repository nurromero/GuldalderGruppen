package com.example.guldaldergruppen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.guldaldergruppen.pages.LoginPage
import com.example.guldaldergruppen.pages.DashboardPage
import com.example.guldaldergruppen.pages.ShiftPlanPage
import com.example.guldaldergruppen.pages.ContactListPage

import com.example.guldaldergruppen.viewmodel.AuthViewModel
import com.example.guldaldergruppen.viewmodel.MainViewModel


@Composable
fun Navigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    mainViewModel: MainViewModel
) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(navController, authViewModel)
        }
        composable("dashboard") {
            DashboardPage(navController, mainViewModel)
        }
        composable("shift_plan") {
            ShiftPlanPage(mainViewModel)
        }
        composable("contacts") {
            ContactListPage(mainViewModel)
        }
    }
}
