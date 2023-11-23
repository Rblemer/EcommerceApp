package br.com.ecommerce_app.domain.usecase.category

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(private val repository: RemoteRepository) :
    CategoryUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return repository.getAllCategoriesListFromApi()
    }
}
