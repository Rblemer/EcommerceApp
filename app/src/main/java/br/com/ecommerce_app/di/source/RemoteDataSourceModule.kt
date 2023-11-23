package br.com.ecommerce_app.di.source

import br.com.ecommerce_app.data.source.remote.RemoteDataSource
import br.com.ecommerce_app.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDataSource(
        dataSource: RemoteDataSourceImpl,
    ): RemoteDataSource
}
