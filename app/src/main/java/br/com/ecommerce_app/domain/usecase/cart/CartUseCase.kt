package br.com.ecommerce_app.domain.usecase.cart

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> // getCartsByUserIdFromLocal

    suspend operator fun invoke(userCartEntity: UserCartEntity) // insertCartToDb
}
