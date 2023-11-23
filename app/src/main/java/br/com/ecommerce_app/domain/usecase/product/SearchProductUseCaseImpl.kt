package br.com.ecommerce_app.domain.usecase.product

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : SearchProductUseCase {
    override fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListBySearchFromApi(query)
    }
}
