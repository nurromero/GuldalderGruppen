package com.example.guldaldergruppen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.viewmodel.AuthViewModel
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import com.example.guldaldergruppen.pages.components.MyTopAppBar
import com.example.guldaldergruppen.pages.components.LogOutFloatingActionButton







@Composable
fun DashboardPage(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    authViewModel: AuthViewModel
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Scaffold(
            topBar = {
                MyTopAppBar(title = "Dashboard")
            },
            floatingActionButton = {
                LogOutFloatingActionButton(onClick = {
                    authViewModel.signOut()
                    navController.navigate("login") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                })
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { navController.navigate("shift_plan") },
                    modifier = Modifier
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Text(
                        text = "    Se vagtplan    ",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("contacts") },
                    modifier = Modifier
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Text(
                        text = "Kontaktpersoner",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


            }
        }
    }

}




