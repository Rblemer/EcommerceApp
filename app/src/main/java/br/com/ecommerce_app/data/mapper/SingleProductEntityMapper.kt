package br.com.ecommerce_app.data.mapper

import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.data.dto.Product
import javax.inject.Inject

class SingleProductEntityMapper @Inject constructor() :
    ProductBaseMapper<Product, DetailProductEntity> {
    override fun map(input: Product): DetailProductEntity {
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toString(),
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}
