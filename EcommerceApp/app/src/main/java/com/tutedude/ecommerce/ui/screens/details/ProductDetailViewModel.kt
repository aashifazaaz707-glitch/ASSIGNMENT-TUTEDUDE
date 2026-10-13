package com.tutedude.ecommerce.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutedude.ecommerce.data.local.FavoriteProductEntity
import com.tutedude.ecommerce.data.remote.model.Product
import com.tutedude.ecommerce.data.repository.FavoriteRepository
import com.tutedude.ecommerce.data.repository.ProductRepository
import com.tutedude.ecommerce.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductDetailUiState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val isFavorite: Boolean = false,
    val errorMessage: String? = null
)

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val favoriteRepository: FavoriteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val productId: String = checkNotNull(savedStateHandle["productId"])

    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    init {
        loadProductDetails()
        observeFavoriteStatus()
    }

    private fun loadProductDetails() {
        viewModelScope.launch {
            productRepository.getProductById(productId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
                    is Resource.Success -> _uiState.value = _uiState.value.copy(isLoading = false, product = resource.data)
                    is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, errorMessage = resource.message)
                }
            }
        }
    }

    private fun observeFavoriteStatus() {
        viewModelScope.launch {
            favoriteRepository.isFavorite(productId).collect { isFav ->
                _uiState.value = _uiState.value.copy(isFavorite = isFav)
            }
        }
    }

    fun toggleFavorite() {
        val currentProduct = _uiState.value.product ?: return
        viewModelScope.launch {
            if (_uiState.value.isFavorite) {
                favoriteRepository.removeFavorite(currentProduct.id)
            } else {
                val entity = FavoriteProductEntity(
                    id = currentProduct.id,
                    title = currentProduct.title,
                    description = currentProduct.description,
                    price = currentProduct.price,
                    imageUrl = currentProduct.images.firstOrNull() ?: "",
                    category = currentProduct.category,
                    uploaderName = currentProduct.uploaderName,
                    uploaderEmail = currentProduct.uploaderEmail
                )
                favoriteRepository.addFavorite(entity)
            }
        }
    }
}
