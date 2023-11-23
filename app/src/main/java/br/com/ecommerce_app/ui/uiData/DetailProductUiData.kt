package br.com.ecommerce_app.ui.uiData

data class DetailProductUiData(
    val productId: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: List<String>,
    val rating: String,
)