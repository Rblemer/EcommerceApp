package br.com.ecommerce_app.domain.usecase.user.forget_pw

interface ForgotPwFirebaseUserUseCase {
    operator fun invoke(
        email: String,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit,
    )
}