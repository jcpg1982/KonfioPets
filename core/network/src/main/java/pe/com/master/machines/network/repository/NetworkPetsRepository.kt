package pe.com.master.machines.network.repository

import kotlinx.coroutines.flow.Flow
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.network.model.PetsNetwork

interface NetworkPetsRepository {

    fun getLoadAllPets(): Flow<Resource<List<PetsNetwork>>>
}