package and.degilevich.dream.shared.feature.artist.design.api.preview.provider

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import kotlinx.collections.immutable.ImmutableList

object ArtistLabelUIDataPreviewProvider {
    fun provide(): ArtistLabelUIData {
        return ArtistLabelUIData.empty().copy(
            name = "Artist",
        )
    }

    fun provideList(): ImmutableList<ArtistLabelUIData> {
        return buildPersistentList {
            for (i in 1..2) {
                add(
                    ArtistLabelUIData.empty().copy(
                        id = i.toString(),
                        name = "Artist $i"
                    )
                )
            }
        }
    }
}