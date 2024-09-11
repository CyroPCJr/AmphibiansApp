package com.example.amphibiansapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibiansApplication
import com.example.amphibiansapp.data.AmphibiansRepository
import com.example.amphibiansapp.network.AmphibiansData
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibiansUiState {
    data class Success(val amphibiansList: List<AmphibiansData>) : AmphibiansUiState
    data object Error : AmphibiansUiState
    data object Loading : AmphibiansUiState
}

class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository) : ViewModel() {

    var amphibiansState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibiansState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }
}

