package and.degilevich.dream.shared.feature.artist.design.api.preview.provider

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.collections.immutable.ImmutableList

class ArtistLabelUIDataPreviewProvider : PreviewParameterProvider<ArtistLabelUIData> {

    override val values: Sequence<ArtistLabelUIData> = sequenceOf(
        provide()
    )

    fun provide(): ArtistLabelUIData {
        return ArtistLabelUIData.empty().copy(
            name = "Artist"
        )
    }

    fun provideList(): ImmutableList<ArtistLabelUIData> {
        return buildPersistentList {
            for (i in 1..2) {
                add(
                    ArtistLabelUIData.empty().copy(
                        id = Identifier(id = i.toString()),
                        name = "Artist $i"
                    )
                )
            }
        }
    }
}