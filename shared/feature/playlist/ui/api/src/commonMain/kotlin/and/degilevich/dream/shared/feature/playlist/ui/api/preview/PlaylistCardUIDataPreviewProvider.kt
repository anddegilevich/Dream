package and.degilevich.dream.shared.feature.playlist.ui.api.preview

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Suppress("MagicNumber")
class PlaylistCardUIDataPreviewProvider : LabeledPreviewParameterProvider<PlaylistCardUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): PlaylistCardUIData {
        return PlaylistCardUIData.empty().copy(
            name = "Playlist"
        )
    }

    fun provideList(): ImmutableList<PlaylistCardUIData> = List(10) { i ->
        PlaylistCardUIData.empty().copy(
            id = identifier(value = i.toString()),
            name = "Playlist $i"
        )
    }.toImmutableList()
}
