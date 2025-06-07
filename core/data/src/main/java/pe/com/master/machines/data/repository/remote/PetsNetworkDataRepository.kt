package pe.com.master.machines.data.repository.remote

import kotlinx.coroutines.flow.Flow
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.model.model.Pets

interface PetsNetworkDataRepository {

    fun getLoadAllPets(): Flow<Resource<List<Pets>>>
}