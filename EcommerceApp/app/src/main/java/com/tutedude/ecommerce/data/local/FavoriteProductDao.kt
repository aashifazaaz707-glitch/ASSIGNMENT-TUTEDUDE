package com.tutedude.ecommerce.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// DAO for managing favorite items in Room database
@Dao
interface FavoriteProductDao {

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<FavoriteProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(product: FavoriteProductEntity)

    @Delete
    suspend fun deleteFavorite(product: FavoriteProductEntity)

    @Query("DELETE FROM favorites WHERE id = :productId")
    suspend fun deleteFavoriteById(productId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :productId)")
    fun isFavorite(productId: String): Flow<Boolean>
}
