package com.tutedude.ecommerce.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutedude.ecommerce.data.local.FavoriteProductEntity
import com.tutedude.ecommerce.data.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    // Local room stream of favorites
    val favorites: StateFlow<List<FavoriteProductEntity>> = favoriteRepository.getAllFavorites()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun removeFavorite(productId: String) {
        viewModelScope.launch {
            favoriteRepository.removeFavorite(productId)
        }
    }
}
