package com.example.guldaldergruppen.pages


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guldaldergruppen.viewmodel.MainViewModel

@Composable
fun ContactListPage(mainViewModel: MainViewModel) {
    val contacts by mainViewModel.contacts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Kontaktliste", style = MaterialTheme.typography.headlineSmall)

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
                        Text(text = contact.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = contact.phone, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
