package br.com.ecommerce_app.di.usecase

import br.com.ecommerce_app.domain.usecase.cart.CartUseCase
import br.com.ecommerce_app.domain.usecase.cart.CartUseCaseImpl
import br.com.ecommerce_app.domain.usecase.cart.DeleteUserCartUseCase
import br.com.ecommerce_app.domain.usecase.cart.DeleteUserCartUseCaseImpl
import br.com.ecommerce_app.domain.usecase.cart.UpdateCartUseCase
import br.com.ecommerce_app.domain.usecase.cart.UpdateCartUseCaseImpl
import br.com.ecommerce_app.domain.usecase.cart.badge.UserCartBadgeUseCase
import br.com.ecommerce_app.domain.usecase.cart.badge.UserCartBadgeUseCaseImpl
import br.com.ecommerce_app.domain.usecase.category.CategoryUseCase
import br.com.ecommerce_app.domain.usecase.category.CategoryUseCaseImpl
import br.com.ecommerce_app.domain.usecase.favorite.DeleteFavoriteUseCase
import br.com.ecommerce_app.domain.usecase.favorite.DeleteFavoriteUseCaseImpl
import br.com.ecommerce_app.domain.usecase.favorite.FavoriteUseCase
import br.com.ecommerce_app.domain.usecase.favorite.FavoriteUseCaseImpl
import br.com.ecommerce_app.domain.usecase.product.GetAllProductsUseCase
import br.com.ecommerce_app.domain.usecase.product.GetAllProductsUseCaseImpl
import br.com.ecommerce_app.domain.usecase.product.GetSingleProductUseCase
import br.com.ecommerce_app.domain.usecase.product.GetSingleProductUseCaseImpl
import br.com.ecommerce_app.domain.usecase.product.SearchProductUseCase
import br.com.ecommerce_app.domain.usecase.product.SearchProductUseCaseImpl
import br.com.ecommerce_app.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCase
import br.com.ecommerce_app.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCaseImpl
import br.com.ecommerce_app.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import br.com.ecommerce_app.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCaseImpl
import br.com.ecommerce_app.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import br.com.ecommerce_app.domain.usecase.user.sign_in.FirebaseUserSingInUseCaseImpl
import br.com.ecommerce_app.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import br.com.ecommerce_app.domain.usecase.user.sign_up.FirebaseUserSignUpUseCaseImpl
import br.com.ecommerce_app.domain.usecase.user.write_user.WriteFirebaseUserInfosCaseImpl
import br.com.ecommerce_app.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl,
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleProductUseCase(
        getSingleProductUseCaseImpl: GetSingleProductUseCaseImpl,
    ): GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCategoryUseCase(
        getAllCategoryUseCaseImpl: CategoryUseCaseImpl,
    ): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCartUseCase(
        cartUseCaseImpl: CartUseCaseImpl,
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        deleteUserCartUseCaseImpl: DeleteUserCartUseCaseImpl,
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUseCase(
        searchUseCaseImpl: SearchProductUseCaseImpl,
    ): SearchProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateCartUseCase(
        updateCartUseCaseImpl: UpdateCartUseCaseImpl,
    ): UpdateCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        favoriteUseCaseImpl: FavoriteUseCaseImpl,
    ): FavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        deleteFavoriteUseCaseImpl: DeleteFavoriteUseCaseImpl,
    ): DeleteFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignUpUseCase(
        firebaseSignUpUseCaseImpl: FirebaseUserSignUpUseCaseImpl,
    ): FirebaseUserSignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignInUseCase(
        firebaseSignInUseCaseImpl: FirebaseUserSingInUseCaseImpl,
    ): FirebaseUserSingInUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseForgetPwUseCase(
        firebaseForgetPwUseCaseImpl: ForgotPwFirebaseUserUseCaseImpl,
    ): ForgotPwFirebaseUserUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseWriteUserUseCase(
        firebaseWriteUserUseCaseImpl: WriteFirebaseUserInfosCaseImpl,
    ): WriteFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseReadUserUseCase(
        firebaseReadUserCaseImpl: ReadFirebaseUserInfosUseCaseImpl,
    ): ReadFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        userCartBadgeUseCaseImpl: UserCartBadgeUseCaseImpl,
    ): UserCartBadgeUseCase
}
