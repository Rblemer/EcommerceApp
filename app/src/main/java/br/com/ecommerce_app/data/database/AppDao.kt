package br.com.ecommerce_app.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserCart(userCartEntity: UserCartEntity)

    @Query("SELECT * FROM user_carts WHERE userId = :userId")
    suspend fun getCartByUserId(userId: String): List<UserCartEntity>

    @Delete
    suspend fun deleteUserCartItem(userCartEntity: UserCartEntity)

    @Update
    suspend fun updateUserCartItem(userCartEntity: UserCartEntity)

    @Query("SELECT * FROM favorite_items WHERE userId = :userId")
    suspend fun getFavoriteProducts(userId: String): List<FavoriteProductEntity>

    @Insert(FavoriteProductEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteItem(favoriteProductEntity: FavoriteProductEntity)

    @Delete(FavoriteProductEntity::class)
    suspend fun deleteFavoriteItem(favoriteProductEntity: FavoriteProductEntity)

    @Query("SELECT COUNT(*) FROM user_carts WHERE userId = :userId")
    suspend fun getBadgeCount(userId: String): Int
}
