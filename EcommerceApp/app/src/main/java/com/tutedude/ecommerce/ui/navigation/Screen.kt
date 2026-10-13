package com.tutedude.ecommerce.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object ProductDetail : Screen("product_detail/{productId}") {
        fun createRoute(productId: String) = "product_detail/$productId"
    }
    object UploadProduct : Screen("upload_product")
    object Favorites : Screen("favorites")
}
