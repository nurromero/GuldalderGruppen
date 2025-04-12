package com.example.guldaldergruppen.pages


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.guldaldergruppen.viewmodel.AuthViewModel
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.pages.components.MyTopAppBar
import com.example.guldaldergruppen.pages.components.LogOutFloatingActionButton

@Composable
fun ContactListPage(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    authViewModel: AuthViewModel
) {

    val contacts by mainViewModel.contacts.collectAsState()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {
        Scaffold(
            topBar = {
                MyTopAppBar(title = "Kontaktliste")
            },
            floatingActionButton = {
                LogOutFloatingActionButton(onClick = {
                    authViewModel.signOut()
                    navController.navigate("login") {
                        popUpTo("contacts") { inclusive = true }
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
                    items(contacts) { contact ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = contact.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = contact.phone,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}