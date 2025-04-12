package com.example.guldaldergruppen.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthRepository {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    // Keeps the user logged in even if the app is closed
    private val _user = MutableStateFlow(firebaseAuth.currentUser)
    val user: StateFlow<FirebaseUser?> = _user

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _errorMessage.value = "Email and password must not be empty"
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _user.value = firebaseAuth.currentUser
                    _errorMessage.value = ""
                } else {
                    _errorMessage.value = task.exception?.message ?: "Unknown error"
                    _user.value = null
                }
            }
    }

    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _user.value = firebaseAuth.currentUser
                    _errorMessage.value = ""
                } else {
                    _errorMessage.value = task.exception?.message ?: "Unknown error"
                }
            }
    }

    fun signOut() {
        firebaseAuth.signOut()
        _user.value = null
    }
}