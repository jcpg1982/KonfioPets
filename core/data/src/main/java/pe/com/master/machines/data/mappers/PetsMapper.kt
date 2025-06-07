package pe.com.master.machines.data.mappers

import pe.com.master.machines.database.database.entity.PetsEntity
import pe.com.master.machines.model.model.Pets

fun Pets.asModel() = PetsEntity(
    age = this.age,
    description = this.description,
    dogName = this.name,
    image = this.image,
)

fun List<Pets>?.asModel() = this?.map { it.asModel() } ?: emptyList()