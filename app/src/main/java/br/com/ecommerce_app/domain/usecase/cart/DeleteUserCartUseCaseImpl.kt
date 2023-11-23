package br.com.ecommerce_app.domain.usecase.cart

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteUserCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.deleteUserCart(userCartEntity)
    }
}
