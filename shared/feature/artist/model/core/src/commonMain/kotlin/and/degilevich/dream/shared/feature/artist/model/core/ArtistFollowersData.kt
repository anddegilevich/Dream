package and.degilevich.dream.shared.feature.artist.model.core

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

interface ArtistFollowersData : EmptyState {
    val total: Int

    data class Base(
        override val total: Int
    ) : ArtistFollowersData {
        override fun isEmpty(): Boolean {
            return total == 0
        }
    }

    companion object : EmptyFactory<ArtistFollowersData> {
        override fun empty(): ArtistFollowersData {
            return Base(
                total = 0
            )
        }
    }
}
