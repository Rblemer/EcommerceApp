package br.com.ecommerce_app.domain.entity.product

data class DetailProductEntity(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: List<String>,
    val rating: String,
)
