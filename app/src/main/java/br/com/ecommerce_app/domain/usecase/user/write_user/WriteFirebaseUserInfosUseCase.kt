package br.com.ecommerce_app.domain.usecase.user.write_user

import br.com.ecommerce_app.domain.entity.user.UserInformationEntity

interface WriteFirebaseUserInfosUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
