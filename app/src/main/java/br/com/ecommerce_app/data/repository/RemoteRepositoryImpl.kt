package br.com.ecommerce_app.data.repository

import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import br.com.ecommerce_app.domain.repository.RemoteRepository
import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.data.dto.Product
import br.com.ecommerce_app.data.source.remote.RemoteDataSource
import br.com.ecommerce_app.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val allProductsMapper: ProductListMapper<Product, ProductEntity>,
    private val singleProductMapper: ProductBaseMapper<Product, DetailProductEntity>,
) : RemoteRepository {
    override fun getProductsListFromApi(): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListFromApi().map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>> {
        return remoteDataSource.getSingleProductByIdFromApi(productId).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(singleProductMapper.map(it.result))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListBySearchFromApi(query).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>> {
        return remoteDataSource.getAllCategoriesListFromApi().map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(it.result)
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return remoteDataSource.getProductsListByCategoryNameFromApi(categoryName).map {
            when (it) {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }
}
