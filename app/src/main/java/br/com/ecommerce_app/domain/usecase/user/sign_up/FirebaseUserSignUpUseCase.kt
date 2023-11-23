package br.com.ecommerce_app.domain.usecase.user.sign_up

import br.com.ecommerce_app.domain.entity.user.UserInformationEntity

interface FirebaseUserSignUpUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
