package eam.retrtofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDataWrapper(
    @SerialName("code") val code: Int,
    @SerialName("status") val status: String,
    @SerialName("data") val data: CharacterDataContainer
)

@Serializable
data class CharacterDataContainer(
    @SerialName("offset") val offset: Int,
    @SerialName("limit") val limit: Int,
    @SerialName("total") val total: Int,
    @SerialName("count") val count: Int,
    @SerialName("results") val results: List<Character>
)

@Serializable
data class Character(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("thumbnail") val thumbnail: Image
)

@Serializable
data class Image(
    @SerialName("path") val path: String,
    @SerialName("extension") val extension: String
)