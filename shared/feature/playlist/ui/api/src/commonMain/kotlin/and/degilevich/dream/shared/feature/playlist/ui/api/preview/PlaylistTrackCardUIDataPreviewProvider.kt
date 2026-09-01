package and.degilevich.dream.shared.feature.playlist.ui.api.preview

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.preview.TrackCardInfoUIDataPreviewProvider
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Suppress("MagicNumber")
class PlaylistTrackCardUIDataPreviewProvider : LabeledPreviewParameterProvider<PlaylistTrackCardUIData>() {

    private val trackCardInfoUIDataPreviewProvider = TrackCardInfoUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Without number" to provideWithoutNumber()
    )

    fun provideDefault(): PlaylistTrackCardUIData {
        return PlaylistTrackCardUIData(
            id = identifier("id"),
            number = "1",
            info = trackCardInfoUIDataPreviewProvider.provideDefault(),
            albumCoverUrl = ""
        )
    }

    fun provideWithoutNumber(): PlaylistTrackCardUIData {
        return provideDefault().copy(number = "")
    }

    fun provideList(): ImmutableList<PlaylistTrackCardUIData> {
        return List(5) { i ->
            PlaylistTrackCardUIData(
                id = identifier(value = i.toString()),
                number = (i + 1).toString(),
                info = trackCardInfoUIDataPreviewProvider.provide(index = i),
                albumCoverUrl = ""
            )
        }.toImmutableList()
    }
}
