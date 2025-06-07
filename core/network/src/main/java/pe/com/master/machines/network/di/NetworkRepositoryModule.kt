package pe.com.master.machines.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.com.master.machines.network.repository.NetworkPetsRepository
import pe.com.master.machines.network.repositoryImpl.NetworkPetsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkRepositoryModule {

    @Binds
    abstract fun provideNetworkPetsRepository(networkPetsRepositoryImpl: NetworkPetsRepositoryImpl): NetworkPetsRepository

}