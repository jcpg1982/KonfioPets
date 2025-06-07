package pe.com.master.machines.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.com.master.machines.database.database.dao.DaoPets
import pe.com.master.machines.database.database.entity.PetsEntity

@Database(
    entities = [
        PetsEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract fun petsDao(): DaoPets

}