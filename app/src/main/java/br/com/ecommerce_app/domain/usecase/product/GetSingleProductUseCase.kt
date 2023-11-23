package br.com.ecommerce_app.domain.usecase.product

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleProductUseCase {
    operator fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>>
}
