package com.example.guldaldergruppen.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.model.Shift


@Composable
fun ShiftPlanPage(mainViewModel: MainViewModel) {
    val shifts by mainViewModel.shifts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Vagtplan", style = MaterialTheme.typography.headlineSmall)

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
    }
}
