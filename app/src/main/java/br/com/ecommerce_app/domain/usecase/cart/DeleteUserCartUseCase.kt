package br.com.ecommerce_app.domain.usecase.cart

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity

interface DeleteUserCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
