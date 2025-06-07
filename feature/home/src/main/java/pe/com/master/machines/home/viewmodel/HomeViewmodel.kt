package pe.com.master.machines.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.com.master.machines.common.response.Resource
import pe.com.master.machines.common.utils.messageError
import pe.com.master.machines.domain.remote.GetAllPetsUsesCase
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val getAllPetsUsesCase: GetAllPetsUsesCase,
) : ViewModel() {

    private val _getAllPets: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.First)
    val getAllPets = _getAllPets.asStateFlow()

    init {
        getAllPets()
    }

    private fun getAllPets() {
        viewModelScope.launch {
            getAllPetsUsesCase.invoke()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _getAllPets.update { HomeState.Loading }
                }
                .catch { e ->
                    _getAllPets.update { HomeState.Error(e) }
                }
                .collect { res ->
                    when (res) {
                        is Resource.Error -> {
                            _getAllPets.update { HomeState.Error(Throwable(res.messageError)) }
                        }

                        is Resource.Success -> {
                            _getAllPets.update { HomeState.Success(res.data) }
                        }
                    }
                }
        }
    }
}