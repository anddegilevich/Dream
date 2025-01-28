package and.degilevich.dream.shared.feature.artist.model.core

import and.degilevich.dream.shared.feature.artist.model.artifact.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified

interface ArtistData : ArtistSimplifiedData {
    val popularity: Int
    val genres: List<String>
    val followers: ArtistFollowersData

    data class Base(
        override val id: String,
        override val name: String,
        override val type: ArtistType,
        override val popularity: Int,
        override val genres: List<String>,
        override val followers: ArtistFollowersData
    ) : ArtistData, AbstractIdentified()

    companion object : EmptyFactory<ArtistData> {
        override fun empty(): ArtistData {
            return Base(
                id = "",
                name = "",
                type = ArtistType.UNKNOWN,
                popularity = 0,
                genres = emptyList(),
                followers = ArtistFollowersData.empty()
            )
        }
    }
}
