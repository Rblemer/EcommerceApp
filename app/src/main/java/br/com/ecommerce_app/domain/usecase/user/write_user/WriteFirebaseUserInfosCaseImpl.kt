package br.com.ecommerce_app.domain.usecase.user.write_user

import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.repository.FirebaseRepository
import javax.inject.Inject

class WriteFirebaseUserInfosCaseImpl @Inject constructor(
    private val repository: FirebaseRepository,
) : WriteFirebaseUserInfosUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        repository.writeNewUserToFirebaseDatabase(user, onSuccess, onFailure)
    }
}
