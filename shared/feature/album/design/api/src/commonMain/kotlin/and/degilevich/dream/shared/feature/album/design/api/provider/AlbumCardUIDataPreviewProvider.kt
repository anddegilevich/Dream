package and.degilevich.dream.shared.feature.album.design.api.provider

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import kotlinx.collections.immutable.ImmutableList

@Suppress("MagicNumber")
class AlbumCardUIDataPreviewProvider : LabeledPreviewParameterProvider<AlbumCardUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): AlbumCardUIData {
        return AlbumCardUIData.empty().copy(
            name = "Album",
            artists = "Artist"
        )
    }

    fun provideList(): ImmutableList<AlbumCardUIData> = buildPersistentList {
        for (i in 1..10) {
            add(
                AlbumCardUIData.empty().copy(
                    id = identifier(value = i.toString()),
                    name = "Album $i",
                    artists = "Artist $i"
                )
            )
        }
    }
}