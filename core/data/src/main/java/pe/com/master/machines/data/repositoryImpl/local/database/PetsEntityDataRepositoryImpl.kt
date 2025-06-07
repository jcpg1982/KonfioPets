package pe.com.master.machines.data.repositoryImpl.local.database

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.common.response.toErrorType
import pe.com.master.machines.data.mappers.asModel
import pe.com.master.machines.data.repository.local.database.PetsEntityDataRepository
import pe.com.master.machines.database.repository.RecipeDatabaseRepository
import pe.com.master.machines.model.model.Pets
import javax.inject.Inject

class PetsEntityDataRepositoryImpl @Inject constructor(private val recipeDatabaseRepository: RecipeDatabaseRepository) :
    PetsEntityDataRepository {

    override fun savePets(entities: List<Pets>) =
        recipeDatabaseRepository.savePets(entities.asModel()).map { res ->
            when (res) {
                is Resource.Error -> Resource.Error(res.error)
                is Resource.Success -> Resource.Success(res.data)
            }
        }.catch { emit(Resource.Error(it.toErrorType())) }

    override fun getAllPetsLocal() =
        recipeDatabaseRepository.getAllPetsLocal().map { res ->
            when (res) {
                is Resource.Error -> Resource.Error(res.error)
                is Resource.Success -> Resource.Success(res.data.asModel())
            }
        }.catch { emit(Resource.Error(it.toErrorType())) }
}