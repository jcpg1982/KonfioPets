package pe.com.master.machines.home.viewmodel

import pe.com.master.machines.model.model.Pets

sealed interface HomeState {

    data object First : HomeState
    data object Loading : HomeState
    data object Unauthorized : HomeState
    data class Error(val throwable: Throwable) : HomeState
    data class Success(val dataList: List<Pets>) : HomeState
}