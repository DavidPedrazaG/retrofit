package eam.retrtofit.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import eam.retrtofit.MarvelCharactersApplication
import eam.retrtofit.data.CharactersRepository
import eam.retrtofit.model.CharacterDataWrapper
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CharacterUiState {
    data class Success(val characters: CharacterDataWrapper) : CharacterUiState
    object Error : CharacterUiState
    object Loading : CharacterUiState
}

class CharacterViewModel(private val charactersRepository: CharactersRepository) : ViewModel() {

    var characterUiState: CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set

    init{
        getCharacters()
    }

    public fun getCharacters(){
        viewModelScope.launch {
            characterUiState = CharacterUiState.Loading
            characterUiState = try {
                CharacterUiState.Success(charactersRepository.getCharacters())
            } catch (e: IOException) {
                CharacterUiState.Error
            } catch (e: HttpException){
                CharacterUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarvelCharactersApplication)
                val charactersRepository = application.container.charactersRepository
                CharacterViewModel(charactersRepository = charactersRepository)
            }
        }
    }
}