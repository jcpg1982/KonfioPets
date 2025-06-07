package pe.com.master.machines.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pe.com.master.machines.design.components.row.PetRow
import pe.com.master.machines.design.components.screen.LoadingDialog
import pe.com.master.machines.design.components.text.CustomText
import pe.com.master.machines.design.components.text.SearchText
import pe.com.master.machines.design.theme.ContentInset
import pe.com.master.machines.design.theme.ContentInsetEight
import pe.com.master.machines.home.viewmodel.HomeState
import pe.com.master.machines.home.viewmodel.HomeViewmodel

@Composable
fun HomeScreen(
    homeViewmodel: HomeViewmodel = hiltViewModel()
) {

    val getAllPets by homeViewmodel.getAllPets.collectAsStateWithLifecycle()

    var searchText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            SearchText(
                hintSearch = "Busca tu mascota",
                maxCharacter = 50,
                modifier = Modifier
                    .padding(horizontal = ContentInset),
                onMessageSearch = {
                    searchText = it
                }
            )

            when (val state = getAllPets) {
                is HomeState.Error -> {}
                HomeState.Loading -> {
                    LoadingDialog()
                }

                is HomeState.Success -> {
                    val dataList = state.dataList
                    val dataListFilter = if (searchText.isBlank()) dataList
                    else dataList.filter { it.name.uppercase().contains(searchText.uppercase()) }

                    if (dataListFilter.isEmpty()) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CustomText(text = "No se encontraron resultados")
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(ContentInsetEight)
                        ) {
                            items(dataListFilter) {
                                PetRow(
                                    item = it,
                                    onDetailPet = {}
                                )
                            }
                        }
                    }
                }

                else -> {}
            }

        }
    }

}