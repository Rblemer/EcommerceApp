package br.com.ecommerce_app.di.repository

import br.com.ecommerce_app.domain.repository.FirebaseRepository
import br.com.ecommerce_app.domain.repository.LocalRepository
import br.com.ecommerce_app.domain.repository.RemoteRepository
import br.com.ecommerce_app.data.repository.FirebaseRepositoryImpl
import br.com.ecommerce_app.data.repository.LocalRepositoryImpl
import br.com.ecommerce_app.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        repository: LocalRepositoryImpl,
    ): LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseRepository(
        repository: FirebaseRepositoryImpl,
    ): FirebaseRepository
}
