package com.tutedude.ecommerce.data.remote

import com.tutedude.ecommerce.data.remote.model.FakeStoreProduct
import retrofit2.http.GET
import retrofit2.http.Path

// Retrofit API interface for FakeStore API
interface FakeStoreApi {

    @GET("products")
    suspend fun getRecommendedProducts(): List<FakeStoreProduct>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): FakeStoreProduct
}
