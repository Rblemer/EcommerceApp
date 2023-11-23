package br.com.ecommerce_app.domain.repository

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {

    fun getProductsListFromApi(): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
