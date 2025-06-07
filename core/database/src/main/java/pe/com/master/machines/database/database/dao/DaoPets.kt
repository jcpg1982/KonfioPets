package pe.com.master.machines.database.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pe.com.master.machines.database.database.entity.PetsEntity

@Dao
interface DaoPets {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePets(entities: List<PetsEntity>)

    @Query("SELECT * FROM PetsEntity")
    fun getAllPetsLocal(): Flow<List<PetsEntity>>

}