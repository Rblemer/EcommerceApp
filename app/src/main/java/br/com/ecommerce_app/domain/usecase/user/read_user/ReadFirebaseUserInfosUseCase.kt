package br.com.ecommerce_app.domain.usecase.user.read_user

import br.com.ecommerce_app.domain.entity.user.UserInformationEntity

interface ReadFirebaseUserInfosUseCase {
    operator fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )
}
