package br.com.ecommerce_app.data.source.local

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity

interface LocalDataSource {
    suspend fun getUserCartByUserIdFromDb(userId: String): List<UserCartEntity>

    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)

    suspend fun deleteUserCartFromDb(userCartEntity: UserCartEntity)

    suspend fun updateUserCartFromDb(userCartEntity: UserCartEntity)

    suspend fun getFavoriteProductsFromDb(userId: String): List<FavoriteProductEntity>

    suspend fun insertFavoriteItemToDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteItemFromDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun getBadgeCountFromDb(userId: String): Int
}
