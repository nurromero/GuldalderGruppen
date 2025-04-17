package com.example.guldaldergruppen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guldaldergruppen.repository.AuthRepository
import kotlinx.coroutines.flow.StateFlow
import com.google.firebase.auth.FirebaseUser

class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()
    val user: StateFlow<FirebaseUser?> = repo.user
    val isAdmin: Boolean
        get() = user.value?.email == ADMIN_EMAIL


    val errorMessage: StateFlow<String> = repo.errorMessage

    companion object {
        const val ADMIN_EMAIL = "admin@guldalder.dk"
    }

    fun signIn(email: String, password: String) = repo.signIn(email, password)
    fun signUp(email: String, password: String) = repo.signUp(email, password)
    fun signOut() = repo.signOut()
}