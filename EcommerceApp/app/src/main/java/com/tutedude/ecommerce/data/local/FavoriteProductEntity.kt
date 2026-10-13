package com.tutedude.ecommerce.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Room Entity for storing favorite products locally
@Entity(tableName = "favorites")
data class FavoriteProductEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val uploaderName: String,
    val uploaderEmail: String
)
