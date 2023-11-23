package br.com.ecommerce_app.domain.usecase.product

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>>

    operator fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
