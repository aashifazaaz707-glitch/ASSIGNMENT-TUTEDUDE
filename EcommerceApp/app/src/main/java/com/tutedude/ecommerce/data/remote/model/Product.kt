package com.tutedude.ecommerce.data.remote.model

// Product model stored in Firebase Firestore
data class Product(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val images: List<String> = emptyList(),
    val category: String = "All",
    val uploaderId: String = "",
    val uploaderName: String = "",
    val uploaderEmail: String = "",
    val uploaderPhone: String = "",
    val createdAt: Long = System.currentTimeMillis()
)
