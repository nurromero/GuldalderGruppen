package com.example.guldaldergruppen.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.viewmodel.AuthViewModel

@Composable
fun DashboardPage(navController: NavHostController, mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome")
    }

    // TODO: fix logout button
    Button(
        onClick = {
            authViewModel.signOut()
            navController.navigate("login")
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Log in")
    }


}
