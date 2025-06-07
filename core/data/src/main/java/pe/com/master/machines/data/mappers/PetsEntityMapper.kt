package pe.com.master.machines.data.mappers

import pe.com.master.machines.database.database.entity.PetsEntity
import pe.com.master.machines.model.model.Pets

fun PetsEntity.asModel() = Pets(
    age = this.age ?: 0,
    description = this.description.orEmpty(),
    name = this.dogName.orEmpty(),
    image = this.image.orEmpty(),
)

fun List<PetsEntity>?.asModel() = this?.map { it.asModel() } ?: emptyList()