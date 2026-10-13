package com.tutedude.ecommerce.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.tutedude.ecommerce.data.remote.FakeStoreApi
import com.tutedude.ecommerce.data.remote.model.FakeStoreProduct
import com.tutedude.ecommerce.data.remote.model.Product
import com.tutedude.ecommerce.util.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val fakeStoreApi: FakeStoreApi
) {

    // Realtime flow for user-uploaded products from Firestore
    fun getUploadedProducts(): Flow<Resource<List<Product>>> = callbackFlow {
        trySend(Resource.Loading())

        val listener = firestore.collection("products")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    trySend(Resource.Error(error.localizedMessage ?: "Failed to load products"))
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    val products = snapshot.toObjects(Product::class.java)
                    trySend(Resource.Success(products))
                }
            }

        awaitClose { listener.remove() }
    }

    // Upload a new product to Firestore
    fun uploadProduct(product: Product): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        try {
            val docRef = firestore.collection("products").document()
            val productWithId = product.copy(id = docRef.id)
            docRef.set(productWithId).await()
            emit(Resource.Success(docRef.id))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Failed to upload product"))
        }
    }

    // Get specific product by ID
    fun getProductById(productId: String): Flow<Resource<Product>> = flow {
        emit(Resource.Loading())
        try {
            val snapshot = firestore.collection("products").document(productId).get().await()
            val product = snapshot.toObject(Product::class.java)
            if (product != null) {
                emit(Resource.Success(product))
            } else {
                emit(Resource.Error("Product not found"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Failed to fetch product details"))
        }
    }

    // Fetch recommended products from FakeStore API (Retrofit)
    fun getRecommendedProducts(): Flow<Resource<List<FakeStoreProduct>>> = flow {
        emit(Resource.Loading())
        try {
            val recommended = fakeStoreApi.getRecommendedProducts()
            emit(Resource.Success(recommended))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Failed to fetch recommended products from FakeStore API"))
        }
    }
}
