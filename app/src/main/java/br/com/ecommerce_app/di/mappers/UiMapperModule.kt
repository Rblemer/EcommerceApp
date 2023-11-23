package br.com.ecommerce_app.di.mappers

import br.com.ecommerce_app.domain.entity.cart.UserCartEntity
import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import br.com.ecommerce_app.domain.entity.product.FavoriteProductEntity
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.entity.user.UserInformationEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import br.com.ecommerce_app.ui.mapper.CartEntityToFavoriteEntityMapper
import br.com.ecommerce_app.ui.mapper.CartEntityToUiMapper
import br.com.ecommerce_app.ui.mapper.CartUiToEntityMapper
import br.com.ecommerce_app.ui.mapper.DetailProductEntityToUiMapper
import br.com.ecommerce_app.ui.mapper.FavoriteEntityToUiMapper
import br.com.ecommerce_app.ui.mapper.FavoriteUiToEntityMapper
import br.com.ecommerce_app.ui.mapper.ProductEntityToUiMapper
import br.com.ecommerce_app.ui.mapper.UserInfoEntityToUiDataMapper
import br.com.ecommerce_app.ui.mapper.UserInfoUiDataToEntityMapper
import br.com.ecommerce_app.ui.uiData.DetailProductUiData
import br.com.ecommerce_app.ui.uiData.FavoriteUiData
import br.com.ecommerce_app.ui.uiData.ProductUiData
import br.com.ecommerce_app.ui.uiData.UserCartUiData
import br.com.ecommerce_app.ui.uiData.UserInformationUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeProductUiMapper(productUiDataMapper: ProductEntityToUiMapper): ProductListMapper<ProductEntity, ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductUiMapper(productUiDataMapper: DetailProductEntityToUiMapper): ProductBaseMapper<DetailProductEntity, DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiMapper(cartUiDataMapper: CartEntityToUiMapper): ProductListMapper<UserCartEntity, UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartUiMapper(singleCartUiDataMapper: CartUiToEntityMapper): ProductBaseMapper<UserCartUiData, UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoEntityToUiDataMapper(userInformationUiDataMapper: UserInfoEntityToUiDataMapper): ProductBaseMapper<UserInformationEntity, UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToEntityMapper(userInformationEntityMapperToUi: UserInfoUiDataToEntityMapper): ProductBaseMapper<UserInformationUiData, UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteItemUiMapper(favoriteEntityToUiMapper: FavoriteEntityToUiMapper): ProductListMapper<FavoriteProductEntity, FavoriteUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleFavoriteItemUiMapper(favoriteUiToEntityMapper: FavoriteUiToEntityMapper): ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartToFavoriteEntityMapper(cartEntityToFavoriteEntityMapper: CartEntityToFavoriteEntityMapper): ProductBaseMapper<UserCartEntity, FavoriteProductEntity>
}
