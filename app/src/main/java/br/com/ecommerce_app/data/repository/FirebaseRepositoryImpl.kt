package br.com.ecommerce_app.data.repository

import br.com.ecommerce_app.domain.entity.user.FirebaseSignInUserEntity
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.repository.FirebaseRepository
import br.com.ecommerce_app.common.TokenManager
import br.com.ecommerce_app.data.source.remote.FirebaseDataSource
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource,
    private val tokenManager: TokenManager,
) : FirebaseRepository {
    override fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.signUpWithFirebase(user, onSuccess, onFailure)
    }

    override fun signInWithFirebase(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.signInWithFirebase(
            user,
            onSuccess = { userInformationEntity ->
                tokenManager.saveToken(userInformationEntity.token)
                onSuccess(userInformationEntity)
            },
            onFailure,
        )
    }

    override fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseDataSource.forgotPassword(email, onSuccess, onFailure)
    }

    override fun writeNewUserToFirebaseDatabase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.writeUserDataToFirebase(user, onSuccess, onFailure)
    }

    override fun readUserFromFirebaseDatabase(
        userMail: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.readUserDataFromFirebase(userMail, onSuccess, onFailure)
    }
}
