package br.com.ecommerce_app.domain.usecase.product

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface SearchProductUseCase {
    operator fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
