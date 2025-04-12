package com.example.guldaldergruppen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guldaldergruppen.repository.AuthRepository
import kotlinx.coroutines.flow.StateFlow
import com.google.firebase.auth.FirebaseUser

class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()
    val user: StateFlow<FirebaseUser?> = repo.user
    val errorMessage: StateFlow<String> = repo.errorMessage

    fun signIn(email: String, password: String) = repo.signIn(email, password)
    fun signUp(email: String, password: String) = repo.signUp(email, password)
    fun signOut() = repo.signOut()
}