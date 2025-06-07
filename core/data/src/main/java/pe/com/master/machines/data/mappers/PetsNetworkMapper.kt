package pe.com.master.machines.data.mappers

import pe.com.master.machines.model.model.Pets
import pe.com.master.machines.network.model.PetsNetwork

fun PetsNetwork.asModel() = Pets(
    age = this.age ?: 0,
    description = this.description.orEmpty(),
    name = this.dogName.orEmpty(),
    image = this.url.orEmpty(),
)

fun List<PetsNetwork>?.asModel() = this?.map { it.asModel() } ?: emptyList()
