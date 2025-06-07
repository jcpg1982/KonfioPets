package pe.com.master.machines.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.com.master.machines.data.repository.local.database.PetsEntityDataRepository
import pe.com.master.machines.data.repository.remote.PetsNetworkDataRepository
import pe.com.master.machines.data.repositoryImpl.local.database.PetsEntityDataRepositoryImpl
import pe.com.master.machines.data.repositoryImpl.remote.PetsNetworkDataRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataRepositoryModule {

    @Binds
    abstract fun providePetsNetworkDataRepository(petsNetworkDataRepositoryImpl: PetsNetworkDataRepositoryImpl): PetsNetworkDataRepository

    @Binds
    abstract fun providePetsEntityDataRepository(petsEntityDataRepositoryImpl: PetsEntityDataRepositoryImpl): PetsEntityDataRepository

}