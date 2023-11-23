package br.com.ecommerce_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity

@Database(entities = [UserCartEntity::class, FavoriteProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
