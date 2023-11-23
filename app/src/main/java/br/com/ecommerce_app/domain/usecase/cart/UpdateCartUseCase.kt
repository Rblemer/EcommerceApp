package br.com.ecommerce_app.domain.usecase.cart // ktlint-disable package-name

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity

interface UpdateCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
