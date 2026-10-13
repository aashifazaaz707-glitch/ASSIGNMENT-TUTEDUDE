package com.tutedude.ecommerce.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutedude.ecommerce.data.remote.model.User
import com.tutedude.ecommerce.data.repository.AuthRepository
import com.tutedude.ecommerce.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthUiState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun isUserLoggedIn(): Boolean = authRepository.isUserLoggedIn()

    fun login(email: String, pass: String) {
        if (email.isBlank() || pass.isBlank()) {
            _uiState.value = AuthUiState(errorMessage = "Please enter both email and password")
            return
        }

        viewModelScope.launch {
            authRepository.login(email.trim(), pass).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _uiState.value = AuthUiState(isLoading = true)
                    is Resource.Success -> _uiState.value = AuthUiState(user = resource.data, isSuccess = true)
                    is Resource.Error -> _uiState.value = AuthUiState(errorMessage = resource.message)
                }
            }
        }
    }

    fun register(name: String, email: String, pass: String) {
        if (name.isBlank() || email.isBlank() || pass.isBlank()) {
            _uiState.value = AuthUiState(errorMessage = "Please fill in all fields")
            return
        }
        if (pass.length < 6) {
            _uiState.value = AuthUiState(errorMessage = "Password must be at least 6 characters")
            return
        }

        viewModelScope.launch {
            authRepository.register(name.trim(), email.trim(), pass).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _uiState.value = AuthUiState(isLoading = true)
                    is Resource.Success -> _uiState.value = AuthUiState(user = resource.data, isSuccess = true)
                    is Resource.Error -> _uiState.value = AuthUiState(errorMessage = resource.message)
                }
            }
        }
    }

    fun clearState() {
        _uiState.value = AuthUiState()
    }

    fun logout() {
        authRepository.logout()
        _uiState.value = AuthUiState()
    }
}
