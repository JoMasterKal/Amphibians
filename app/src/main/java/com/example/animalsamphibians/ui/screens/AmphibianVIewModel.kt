package com.example.animalsamphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsamphibians.data.model.AmphibianModel
import com.example.animalsamphibians.domain.repository.AmphibianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

sealed interface AmphibianUiState {
    data class Success(val animals: List<AmphibianModel>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}


@HiltViewModel
class AmphibianVIewModel @Inject constructor(
    private val repository: AmphibianRepository
) : ViewModel() {

    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }


    fun getAmphibians() {
        viewModelScope.launch {
            val listResult = repository.getAmphibians()
                //AmphibianApi.retrofitService.getAmphibians()
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