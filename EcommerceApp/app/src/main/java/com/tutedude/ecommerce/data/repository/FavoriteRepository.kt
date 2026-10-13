package com.tutedude.ecommerce.data.repository

import com.tutedude.ecommerce.data.local.FavoriteProductDao
import com.tutedude.ecommerce.data.local.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteProductDao
) {

    fun getAllFavorites(): Flow<List<FavoriteProductEntity>> {
        return favoriteDao.getAllFavorites()
    }

    fun isFavorite(productId: String): Flow<Boolean> {
        return favoriteDao.isFavorite(productId)
    }

    suspend fun addFavorite(product: FavoriteProductEntity) {
        favoriteDao.insertFavorite(product)
    }

    suspend fun removeFavorite(productId: String) {
        favoriteDao.deleteFavoriteById(productId)
    }
}
