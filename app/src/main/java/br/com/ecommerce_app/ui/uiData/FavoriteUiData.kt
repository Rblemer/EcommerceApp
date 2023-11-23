package br.com.ecommerce_app.ui.uiData

data class FavoriteUiData(
    val userId: String,
    val productId: Int,
    val price: Int,
    val quantity: Int,
    val title: String,
    val imageUrl: String,
)