package br.com.ecommerce_app.domain.usecase.favorite

import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity
import br.com.ecommerce_app.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : DeleteFavoriteUseCase {
    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        repository.deleteFavoriteProduct(favoriteProductEntity)
    }
}
