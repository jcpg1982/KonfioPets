package pe.com.master.machines.domain.remote

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.data.repository.local.database.PetsEntityDataRepository
import pe.com.master.machines.data.repository.remote.PetsNetworkDataRepository
import pe.com.master.machines.model.model.Pets
import javax.inject.Inject

class GetAllPetsUsesCase @Inject constructor(
    private val petsNetworkDataRepository: PetsNetworkDataRepository,
    private val petsEntityDataRepository: PetsEntityDataRepository,
) {

    operator fun invoke() = flow {
        val local = petsEntityDataRepository.getAllPetsLocal().first()
        val result = when (local) {
            is Resource.Error -> fetchFromRemoteAndSave()
            is Resource.Success ->
                if (local.data.isEmpty()) fetchFromRemoteAndSave()
                else local
        }
        emit(result)
    }

    private suspend fun fetchFromRemoteAndSave(): Resource<List<Pets>> {
        val remoteResult = petsNetworkDataRepository.getLoadAllPets().first()
        if (remoteResult is Resource.Success) {
            petsEntityDataRepository.savePets(remoteResult.data).collect {}
        }
        return remoteResult
    }


}

