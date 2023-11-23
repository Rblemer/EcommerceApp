package br.com.ecommerce_app.di.source

import br.com.ecommerce_app.data.source.local.LocalDataSource
import br.com.ecommerce_app.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    @ViewModelScoped
    abstract fun bindLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource
}
