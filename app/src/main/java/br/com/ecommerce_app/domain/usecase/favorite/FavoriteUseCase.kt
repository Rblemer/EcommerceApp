package br.com.ecommerce_app.domain.usecase.favorite

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> // getFavoriteProductsFromLocal

    suspend operator fun invoke(item: FavoriteProductEntity) // insertFavoriteItemToDb
}
