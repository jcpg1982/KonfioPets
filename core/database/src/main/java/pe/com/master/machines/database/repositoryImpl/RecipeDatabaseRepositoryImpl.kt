package pe.com.master.machines.database.repositoryImpl

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.database.database.DataBase
import pe.com.master.machines.database.database.entity.PetsEntity
import pe.com.master.machines.database.repository.RecipeDatabaseRepository
import javax.inject.Inject

class RecipeDatabaseRepositoryImpl @Inject constructor(database: DataBase) :
    RecipeDatabaseRepository {

    private val TAG = RecipeDatabaseRepositoryImpl::class.java.simpleName

    private val centroCostoDao = database.petsDao()

    override fun savePets(entities: List<PetsEntity>) = flow {
        val result = centroCostoDao.savePets(entities)
        emit(Resource.Success(result))
    }

    override fun getAllPetsLocal() =
        centroCostoDao.getAllPetsLocal()
            .map { Resource.Success(it) }

}