package com.tutedude.ecommerce.ui.screens.upload

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutedude.ecommerce.data.remote.model.Product
import com.tutedude.ecommerce.data.repository.AuthRepository
import com.tutedude.ecommerce.data.repository.ProductRepository
import com.tutedude.ecommerce.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UploadUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)

@HiltViewModel
class UploadViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UploadUiState())
    val uiState: StateFlow<UploadUiState> = _uiState.asStateFlow()

    fun uploadProduct(
        title: String,
        description: String,
        priceStr: String,
        category: String,
        imageUrls: List<String>,
        contactPhone: String
    ) {
        val price = priceStr.toDoubleOrNull()
        if (title.isBlank() || description.isBlank() || price == null || price <= 0) {
            _uiState.value = UploadUiState(errorMessage = "Please enter valid title, description, and price.")
            return
        }

        val validImages = imageUrls.filter { it.isNotBlank() }
        if (validImages.size < 3) {
            _uiState.value = UploadUiState(errorMessage = "Please provide at least 3 product image URLs.")
            return
        }

        val currentUserId = authRepository.currentUserId ?: "guest_user"
        val currentUserEmail = authRepository.currentUserEmail ?: ""

        val newProduct = Product(
            title = title.trim(),
            description = description.trim(),
            price = price,
            category = category,
            images = validImages,
            uploaderId = currentUserId,
            uploaderEmail = currentUserEmail,
            uploaderPhone = contactPhone.trim(),
            createdAt = System.currentTimeMillis()
        )

        viewModelScope.launch {
            productRepository.uploadProduct(newProduct).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _uiState.value = UploadUiState(isLoading = true)
                    is Resource.Success -> _uiState.value = UploadUiState(isSuccess = true)
                    is Resource.Error -> _uiState.value = UploadUiState(errorMessage = resource.message)
                }
            }
        }
    }

    fun resetState() {
        _uiState.value = UploadUiState()
    }
}
