package and.degilevich.dream.shared.feature.album.design.api.preview.provider

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import kotlinx.collections.immutable.ImmutableList

@Suppress("MagicNumber")
object AlbumCardUIDataPreviewProvider {

    fun provide(): AlbumCardUIData {
        return AlbumCardUIData.empty().copy(
            name = "Album",
            artists = "Artist"
        )
    }

    fun provideList(): ImmutableList<AlbumCardUIData> = buildPersistentList {
        for (i in 1..10) {
            add(
                AlbumCardUIData.Companion.empty().copy(
                    id = i.toString(),
                    name = "Album $i",
                    artists = "Artist $i"
                )
            )
        }
    }
}