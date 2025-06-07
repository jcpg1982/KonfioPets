package pe.com.master.machines.network.repositoryImpl

import kotlinx.coroutines.flow.flow
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.network.api.ApiService
import pe.com.master.machines.network.repository.NetworkPetsRepository
import javax.inject.Inject

class NetworkPetsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    NetworkPetsRepository {

    override fun getLoadAllPets() = flow {
        val response = apiService.getLoadAllCategories()
        emit(Resource.Success(response))
    }
}