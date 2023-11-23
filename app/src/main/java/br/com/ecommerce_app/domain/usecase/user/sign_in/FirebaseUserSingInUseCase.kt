package br.com.ecommerce_app.domain.usecase.user.sign_in

import br.com.ecommerce_app.domain.entity.user.FirebaseSignInUserEntity
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity

interface FirebaseUserSingInUseCase {
    operator fun invoke(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}