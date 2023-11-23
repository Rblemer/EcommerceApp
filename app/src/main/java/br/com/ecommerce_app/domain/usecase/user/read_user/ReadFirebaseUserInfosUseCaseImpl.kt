package br.com.ecommerce_app.domain.usecase.user.read_user

import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.repository.FirebaseRepository
import javax.inject.Inject

class ReadFirebaseUserInfosUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository
): ReadFirebaseUserInfosUseCase {
    override fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        repository.readUserFromFirebaseDatabase(userId, onSuccess, onFailure)
    }
}