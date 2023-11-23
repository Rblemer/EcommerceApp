package br.com.ecommerce_app.domain.usecase.user.sign_in

import br.com.ecommerce_app.domain.entity.user.FirebaseSignInUserEntity
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseUserSingInUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
): FirebaseUserSingInUseCase {
    override fun invoke(user: FirebaseSignInUserEntity, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        firebaseRepository.signInWithFirebase(user, onSuccess, onFailure)
    }
}