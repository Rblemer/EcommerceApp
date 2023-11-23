package br.com.ecommerce_app.domain.usecase.product

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetAllProductsUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>> = repository.getProductsListFromApi()

    override fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListByCategoryNameFromApi(categoryName)
    }
}
