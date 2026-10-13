package com.tutedude.ecommerce.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tutedude.ecommerce.data.remote.model.User
import com.tutedude.ecommerce.util.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {

    val currentUserId: String?
        get() = auth.currentUser?.uid

    val currentUserEmail: String?
        get() = auth.currentUser?.email

    fun isUserLoggedIn(): Boolean = auth.currentUser != null

    // Register user with Email and Password
    fun register(name: String, email: String, pass: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val result = auth.createUserWithEmailAndPassword(email, pass).await()
            val uid = result.user?.uid ?: throw Exception("Failed to retrieve user ID")
            val user = User(uid = uid, name = name, email = email)

            // Save user profile in Firestore
            firestore.collection("users").document(uid).set(user).await()
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Registration failed"))
        }
    }

    // Login with Email and Password
    fun login(email: String, pass: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val result = auth.signInWithEmailAndPassword(email, pass).await()
            val uid = result.user?.uid ?: throw Exception("Failed to retrieve user ID")

            // Fetch user info from Firestore
            val doc = firestore.collection("users").document(uid).get().await()
            val user = doc.toObject(User::class.java) ?: User(uid = uid, email = email, name = email.substringBefore("@"))
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Invalid credentials or login failure"))
        }
    }

    fun logout() {
        auth.signOut()
    }
}
