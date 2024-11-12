package eam.retrtofit.data

import eam.retrtofit.model.CharacterDataWrapper
import eam.retrtofit.network.CharactersApiService

interface CharactersRepository {

    suspend fun getCharacters(): CharacterDataWrapper
}

class NetworkCharactersRepository(
    private val characterApiService: CharactersApiService
) : CharactersRepository {

    override suspend fun getCharacters(): CharacterDataWrapper = characterApiService.getCharacters()
}