package com.example.guldaldergruppen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.guldaldergruppen.viewmodel.AuthViewModel
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.Navigation
import androidx.compose.ui.tooling.preview.Preview
import com.example.guldaldergruppen.ui.theme.GuldalderGruppenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GuldalderGruppenTheme {
                val navController = rememberNavController()
                val authViewModel = AuthViewModel()
                val mainViewModel = MainViewModel()
                Navigation(navController, authViewModel, mainViewModel)
            }

            }
        }
    }




