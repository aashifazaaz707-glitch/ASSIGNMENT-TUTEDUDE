package com.tutedude.ecommerce.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tutedude.ecommerce.ui.screens.auth.AuthViewModel
import com.tutedude.ecommerce.ui.screens.auth.LoginScreen
import com.tutedude.ecommerce.ui.screens.auth.RegisterScreen
import com.tutedude.ecommerce.ui.screens.details.ProductDetailScreen
import com.tutedude.ecommerce.ui.screens.details.ProductDetailViewModel
import com.tutedude.ecommerce.ui.screens.favorites.FavoritesScreen
import com.tutedude.ecommerce.ui.screens.favorites.FavoritesViewModel
import com.tutedude.ecommerce.ui.screens.home.HomeScreen
import com.tutedude.ecommerce.ui.screens.home.HomeViewModel
import com.tutedude.ecommerce.ui.screens.upload.UploadProductScreen
import com.tutedude.ecommerce.ui.screens.upload.UploadViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Login Screen
        composable(Screen.Login.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        // Register Screen
        composable(Screen.Register.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            RegisterScreen(
                viewModel = authViewModel,
                onRegisterSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }

        // Home Screen
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = homeViewModel,
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                },
                onNavigateToUpload = {
                    navController.navigate(Screen.UploadProduct.route)
                },
                onNavigateToFavorites = {
                    navController.navigate(Screen.Favorites.route)
                }
            )
        }

        // Product Details Screen
        composable(
            route = Screen.ProductDetail.route,
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType }
            )
        ) {
            val detailViewModel: ProductDetailViewModel = hiltViewModel()
            ProductDetailScreen(
                viewModel = detailViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Upload Product Screen
        composable(Screen.UploadProduct.route) {
            val uploadViewModel: UploadViewModel = hiltViewModel()
            UploadProductScreen(
                viewModel = uploadViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Favorites Screen (Room Local DB)
        composable(Screen.Favorites.route) {
            val favoritesViewModel: FavoritesViewModel = hiltViewModel()
            FavoritesScreen(
                viewModel = favoritesViewModel,
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
