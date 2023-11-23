package br.com.ecommerce_app.ui.mapper // ktlint-disable filename

import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.ui.uiData.DetailProductUiData
import javax.inject.Inject

class DetailProductEntityToUiMapper @Inject constructor() :
    ProductBaseMapper<DetailProductEntity, DetailProductUiData> {
    override fun map(input: DetailProductEntity): DetailProductUiData {
        return DetailProductUiData(
            productId = input.id,
            title = input.title,
            description = input.description,
            price = input.price,
            imageUrl = input.imageUrl,
            rating = input.rating,
        )
    }
}
