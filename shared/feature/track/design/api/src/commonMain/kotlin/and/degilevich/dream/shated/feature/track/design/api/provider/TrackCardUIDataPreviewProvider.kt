package and.degilevich.dream.shated.feature.track.design.api.provider

import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList

@Suppress("MagicNumber")
class TrackCardUIDataPreviewProvider : LabeledPreviewParameterProvider<TrackCardUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): TrackCardUIData {
        return TrackCardUIData.empty().copy(
            number = "1",
            name = "Track",
            artists = "Artist",
        )
    }

    fun provideList(): ImmutableList<TrackCardUIData> {
        return buildPersistentList {
            for (i in 1..5) {
                add(
                    TrackCardUIData.empty().copy(
                        id = identifier(value = i.toString()),
                        number = i.toString(),
                        name = "Track $i",
                        artists = "Artist"
                    )
                )
            }
        }
    }
}