package br.com.ecommerce_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
) {
    object Home : BottomNavItem(
        title = "Inicio",
        icon = Icons.Default.Home,
        route = br.com.ecommerce_app.navigation.Home.route,
    )

    object Cart : BottomNavItem(
        title = "Carrinho",
        icon = Icons.Default.ShoppingCart,
        route = br.com.ecommerce_app.navigation.Cart.route,
    )

    object Favorite : BottomNavItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite,
        route = br.com.ecommerce_app.navigation.Favorite.route,
    )

    object Profile : BottomNavItem(
        title = "Perfil",
        icon = Icons.Default.AccountCircle,
        route = br.com.ecommerce_app.navigation.Profile.route,
    )
}
