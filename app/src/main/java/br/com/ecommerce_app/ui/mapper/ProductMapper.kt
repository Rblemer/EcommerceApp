package br.com.ecommerce_app.ui.mapper

import br.com.ecommerce_app.ui.uiData.ProductUiData
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import javax.inject.Inject

class ProductEntityToUiMapper @Inject constructor() :
    ProductListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
        return input.map {
            ProductUiData(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                imageUrl = it.imageUrl,
                rating = it.rating,
            )
        }
    }
}
