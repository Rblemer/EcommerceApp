package br.com.ecommerce_app.domain.usecase.favorite

import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity

interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}