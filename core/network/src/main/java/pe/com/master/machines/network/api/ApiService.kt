package pe.com.master.machines.network.api

import pe.com.master.machines.network.model.PetsNetwork
import pe.com.master.machines.network.utils.Utils.Endpoints.LOAD_ALL
import retrofit2.http.GET

interface ApiService {

    @GET(LOAD_ALL)
    suspend fun getLoadAllCategories(): List<PetsNetwork>
}