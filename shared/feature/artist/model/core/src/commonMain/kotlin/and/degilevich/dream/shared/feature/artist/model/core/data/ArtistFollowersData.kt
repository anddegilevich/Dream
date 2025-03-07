package and.degilevich.dream.shared.feature.artist.model.core.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class ArtistFollowersData(
    val total: Int
) : EmptyState {

    override fun isEmpty(): Boolean {
        return total == 0
    }

    companion object : EmptyFactory<ArtistFollowersData> {
        override fun empty(): ArtistFollowersData {
            return ArtistFollowersData(
                total = 0
            )
        }
    }
}