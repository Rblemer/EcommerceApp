package br.com.ecommerce_app.domain.usecase.cart.badge

import br.com.ecommerce_app.common.NetworkResponseState
import br.com.ecommerce_app.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCartBadgeUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UserCartBadgeUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<Int>> {
        return repository.getBadgeCountFromDb(userId)
    }
}
