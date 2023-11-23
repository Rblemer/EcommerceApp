package br.com.ecommerce_app.data.source.remote

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.data.dto.Product
import br.com.ecommerce_app.data.dto.Products
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getProductsListFromApi(): Flow<NetworkResponseState<Products>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>
}
