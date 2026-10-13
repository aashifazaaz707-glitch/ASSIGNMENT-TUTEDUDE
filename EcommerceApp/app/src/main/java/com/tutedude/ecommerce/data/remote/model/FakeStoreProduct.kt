package com.tutedude.ecommerce.data.remote.model

// Model representing products retrieved from FakeStore API
data class FakeStoreProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating? = null
)

data class Rating(
    val rate: Double,
    val count: Int
)
