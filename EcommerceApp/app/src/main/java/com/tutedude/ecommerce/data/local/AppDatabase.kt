package com.tutedude.ecommerce.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// Room Database setup for local data persistence
@Database(
    entities = [FavoriteProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteProductDao(): FavoriteProductDao
}
