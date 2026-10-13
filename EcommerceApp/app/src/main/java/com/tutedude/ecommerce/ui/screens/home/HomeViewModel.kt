package com.tutedude.ecommerce.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutedude.ecommerce.data.remote.model.FakeStoreProduct
import com.tutedude.ecommerce.data.remote.model.Product
import com.tutedude.ecommerce.data.repository.ProductRepository
import com.tutedude.ecommerce.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val recommendedProducts: List<FakeStoreProduct> = emptyList(),
    val filteredProducts: List<Product> = emptyList(),
    val searchQuery: String = "",
    val selectedCategory: String = "All",
    val errorMessage: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadProducts()
        loadRecommendedProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            productRepository.getUploadedProducts().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
                    is Resource.Success -> {
                        val list = resource.data ?: emptyList()
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            products = list,
                            filteredProducts = applyFilter(list, _uiState.value.searchQuery, _uiState.value.selectedCategory)
                        )
                    }
                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            errorMessage = resource.message
                        )
                    }
                }
            }
        }
    }

    private fun loadRecommendedProducts() {
        viewModelScope.launch {
            productRepository.getRecommendedProducts().collect { resource ->
                if (resource is Resource.Success) {
                    _uiState.value = _uiState.value.copy(
                        recommendedProducts = resource.data ?: emptyList()
                    )
                }
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(
            searchQuery = query,
            filteredProducts = applyFilter(_uiState.value.products, query, _uiState.value.selectedCategory)
        )
    }

    fun onCategorySelected(category: String) {
        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            filteredProducts = applyFilter(_uiState.value.products, _uiState.value.searchQuery, category)
        )
    }

    private fun applyFilter(products: List<Product>, query: String, category: String): List<Product> {
        return products.filter { product ->
            val matchesCategory = if (category == "All") true else product.category.equals(category, ignoreCase = true)
            val matchesSearch = if (query.isBlank()) true else {
                product.title.contains(query, ignoreCase = true) || product.description.contains(query, ignoreCase = true)
            }
            matchesCategory && matchesSearch
        }
    }
}
