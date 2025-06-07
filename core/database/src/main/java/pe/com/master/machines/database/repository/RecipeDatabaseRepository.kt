package pe.com.master.machines.database.repository

import kotlinx.coroutines.flow.Flow
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.database.database.entity.PetsEntity

interface RecipeDatabaseRepository {

    fun savePets(entities: List<PetsEntity>): Flow<Resource<Unit>>
    fun getAllPetsLocal(): Flow<Resource<List<PetsEntity>>>
}