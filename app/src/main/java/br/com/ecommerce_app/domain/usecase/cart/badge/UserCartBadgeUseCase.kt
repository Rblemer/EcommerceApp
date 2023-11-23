package br.com.ecommerce_app.domain.usecase.cart.badge

import br.com.ecommerce_app.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface UserCartBadgeUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<Int>>
}