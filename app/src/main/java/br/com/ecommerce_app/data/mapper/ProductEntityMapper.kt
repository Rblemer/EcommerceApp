package br.com.ecommerce_app.data.mapper

import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import br.com.ecommerce_app.data.dto.Product
import javax.inject.Inject

class ProductEntityMapper @Inject constructor() :
    ProductListMapper<Product, ProductEntity> {
    override fun map(input: List<Product>): List<ProductEntity> {
        return input.map {
            ProductEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price.toString(),
                imageUrl = it.images[0],
                rating = it.rating,
            )
        }
    }
}
