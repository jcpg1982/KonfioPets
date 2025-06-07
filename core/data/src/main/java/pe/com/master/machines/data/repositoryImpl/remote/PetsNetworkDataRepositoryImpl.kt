package pe.com.master.machines.data.repositoryImpl.remote

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.common.response.toErrorType
import pe.com.master.machines.data.mappers.asModel
import pe.com.master.machines.data.repository.remote.PetsNetworkDataRepository
import pe.com.master.machines.network.repositoryImpl.NetworkPetsRepositoryImpl
import javax.inject.Inject

class PetsNetworkDataRepositoryImpl @Inject constructor(
    private val networkPetsRepositoryImpl: NetworkPetsRepositoryImpl
) : PetsNetworkDataRepository {

    override fun getLoadAllPets() = networkPetsRepositoryImpl.getLoadAllPets()
        .map { res ->
            when (res) {
                is Resource.Error<*> -> Resource.Error(res.error)
                is Resource.Success -> Resource.Success(res.data.asModel())
            }
        }
        .catch { emit(Resource.Error(it.toErrorType())) }

}