package and.degilevich.dream.shared.feature.artist.ui.api.preview

import and.degilevich.dream.shared.feature.artist.ui.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList
import kotlinx.collections.immutable.ImmutableList

class ArtistLabelUIDataPreviewProvider : LabeledPreviewParameterProvider<ArtistLabelUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): ArtistLabelUIData {
        return ArtistLabelUIData.empty().copy(
            name = "Artist"
        )
    }

    fun provideList(): ImmutableList<ArtistLabelUIData> {
        return buildPersistentList {
            for (i in 1..2) {
                add(
                    ArtistLabelUIData.empty().copy(
                        id = identifier(value = i.toString()),
                        name = "Artist $i"
                    )
                )
            }
        }
    }
}