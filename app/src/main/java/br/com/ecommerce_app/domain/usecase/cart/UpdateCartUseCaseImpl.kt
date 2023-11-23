package br.com.ecommerce_app.domain.usecase.cart // ktlint-disable package-name

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.repository.LocalRepository
import javax.inject.Inject

class UpdateCartUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UpdateCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.updateUserCart(userCartEntity)
    }
}
