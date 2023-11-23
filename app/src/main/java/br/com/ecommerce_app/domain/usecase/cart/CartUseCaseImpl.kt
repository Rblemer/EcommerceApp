package br.com.ecommerce_app.domain.usecase.cart

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor(private val repository: LocalRepository) : CartUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> = repository.getCartsByUserIdFromDb(userId)
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.insertUserCartToDb(userCartEntity)
    }
}
