package pe.com.master.machines.data.repository.local.database

import kotlinx.coroutines.flow.Flow
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.model.model.Pets

interface PetsEntityDataRepository {


    fun savePets(entities: List<Pets>): Flow<Resource<Unit>>
    fun getAllPetsLocal(): Flow<Resource<List<Pets>>>
}