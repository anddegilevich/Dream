package and.degilevich.dream.shated.feature.track.design.api.preview.provider

import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList

@Suppress("MagicNumber")
object TrackCardUIDataPreviewProvider {
    fun provide(): TrackCardUIData {
        return TrackCardUIData.empty().copy(
            number = "1",
            name = "Track",
            artists = "Artist",
        )
    }

    fun provideList(): ImmutableList<TrackCardUIData> {
        return buildPersistentList {
            for (i in 1..10) {
                add(
                    TrackCardUIData.empty().copy(
                        id = i.toString(),
                        number = i.toString(),
                        name = "Track $i",
                        artists = "Artist"
                    )
                )
            }
        }
    }
}