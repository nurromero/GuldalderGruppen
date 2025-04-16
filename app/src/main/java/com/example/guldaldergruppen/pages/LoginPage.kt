package com.example.guldaldergruppen.pages



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.guldaldergruppen.viewmodel.AuthViewModel
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.google.firebase.auth.FirebaseUser
import androidx.compose.ui.Alignment
import com.example.guldaldergruppen.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



@Composable
fun LoginPage(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    mainViewModel: MainViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember {
        mutableStateOf<String?>(null)
    }
    val user by authViewModel.user.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {


        LaunchedEffect(user) {
            if (user != null) {
                navController.navigate("dashboard") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.guldalder_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp)
                    .size(200.dp)
                    .clip(RoundedCornerShape(24.dp))
            )


            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Velkommen",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF3E3E54),
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        authViewModel.signIn(email, password)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Log in")
                }
            }
        }
    }
}
