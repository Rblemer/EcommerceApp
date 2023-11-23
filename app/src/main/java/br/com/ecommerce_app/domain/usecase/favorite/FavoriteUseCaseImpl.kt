package br.com.ecommerce_app.domain.usecase.favorite

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity
import br.com.ecommerce_app.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : FavoriteUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> =
        repository.getFavoriteProductsFromDb(userId)

    override suspend fun invoke(item: FavoriteProductEntity) {
        repository.insertFavoriteProductToDb(item)
    }
}
