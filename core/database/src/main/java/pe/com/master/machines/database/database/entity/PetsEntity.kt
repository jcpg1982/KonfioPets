package pe.com.master.machines.database.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PetsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val age: Int? = null,
    val description: String? = null,
    val dogName: String? = null,
    val image: String? = null
)