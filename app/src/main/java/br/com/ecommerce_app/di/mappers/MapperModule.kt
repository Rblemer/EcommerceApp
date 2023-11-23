package br.com.ecommerce_app.di.mappers

import br.com.ecommerce_app.domain.entity.product.DetailProductEntity
import br.com.ecommerce_app.domain.entity.product.ProductEntity
import br.com.ecommerce_app.domain.mapper.ProductBaseMapper
import br.com.ecommerce_app.domain.mapper.ProductListMapper
import br.com.ecommerce_app.data.dto.Product
import br.com.ecommerce_app.data.mapper.ProductEntityMapper
import br.com.ecommerce_app.data.mapper.SingleProductEntityMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAllProductsEntityMapper(productEntityMapper: ProductEntityMapper): ProductListMapper<Product, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper): ProductBaseMapper<Product, DetailProductEntity>
}
