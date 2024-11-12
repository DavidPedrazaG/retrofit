package eam.retrtofit.network

import eam.retrtofit.model.CharacterDataWrapper
import retrofit2.http.GET

interface CharactersApiService {
    @GET("http://gateway.marvel.com/v1/public/characters?ts=1&apikey=224433688d4dc9390f36134d4b271ec3&hash=c15ec94719af9659e490fe3953850034")
    suspend fun getCharacters(): CharacterDataWrapper
}