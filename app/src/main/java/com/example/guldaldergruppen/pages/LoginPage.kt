package com.example.guldaldergruppen.pages



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.guldaldergruppen.R
import com.example.guldaldergruppen.viewmodel.AuthViewModel
import com.example.guldaldergruppen.viewmodel.MainViewModel
import com.example.guldaldergruppen.pages.components.ThemedBackground




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    mainViewModel: MainViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val user by authViewModel.user.collectAsState()
    var error by remember {
        mutableStateOf<String?>(null)
    }


        LaunchedEffect(user) {
            if (user != null) {
                navController.navigate("dashboard") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }

    ThemedBackground {
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
                    .size(150.dp)
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

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Username", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Gray,
                        focusedIndicatorColor = Color.DarkGray,
                        cursorColor = Color.Black
                    )
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Password", color = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Gray,
                        focusedIndicatorColor = Color.DarkGray,
                        cursorColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = {
                        authViewModel.signIn(email, password)
                    },
                    modifier = Modifier
                        .width(250.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF3E3E54)
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(
                    onClick = { navController.navigate("loginwadmin") },
                ) {
                    Text(
                        text = "Logging in as an Admin? Click here",
                        fontSize = 14.sp,
                        color = Color(0xFF3E3E54)
                    )
                }
            }

            Text(
                text = "www.guldaldergruppen.dk",
                fontSize = 14.sp,
                color = Color(0xFF3E3E54),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            )
        }
    }
}