package com.example.guldaldergruppen.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.model.Shift
import com.example.guldaldergruppen.pages.components.LogOutFloatingActionButton
import com.example.guldaldergruppen.pages.components.MyTopAppBar
import com.example.guldaldergruppen.viewmodel.AuthViewModel


@Composable
fun ShiftPlanPage(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    val shifts by mainViewModel.shifts.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Scaffold(
            topBar = {
                MyTopAppBar(title = "Vagtplan")
            },
            floatingActionButton = {
                LogOutFloatingActionButton(onClick = {
                    authViewModel.signOut()
                    navController.navigate("login") {
                        popUpTo("shift_plan") { inclusive = true }
                    }
                })
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(shifts) { shift ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "Dato: ${shift.date}")
                                Text(text = "Adresse: ${shift.address}")
                                Text(text = "Tidspunkt: ${shift.time}")
                            }
                        }
                    }
                }
                if (authViewModel.isAdmin) {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3E3E54),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Tilføj Vagt")
                    }
                }


                }
            }
        }
    }
