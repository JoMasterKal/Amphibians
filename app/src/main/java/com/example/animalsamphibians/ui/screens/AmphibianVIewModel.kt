package com.example.animalsamphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsamphibians.model.AmphibianModel
import com.example.animalsamphibians.network.AmphibianApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val animals: List<AmphibianModel>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}


class AmphibianVIewModel : ViewModel() {

    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }


    fun getAmphibians() {
        viewModelScope.launch {
            val listResult = AmphibianApi.retrofitService.getAmphibians()
            print("######### $listResult ######")
            amphibianUiState =
                try {
                AmphibianUiState.Success(listResult)
            }catch (e: IOException) {
                AmphibianUiState.Error
            }
        }
    }
}