package br.com.ecommerce_app.data.source.remote

import br.com.ecommerce_app.domain.entity.user.FirebaseSignInUserEntity
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity

interface FirebaseDataSource {
    fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun signInWithFirebase(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun forgotPassword(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun writeUserDataToFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun readUserDataFromFirebase(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )
}
