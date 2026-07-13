package and.degilevich.dream.shared.feature.artist.component.details.impl.preview

import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistInfoLayoutUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class ArtistInfoLayoutUIDataPreviewProvider : LabeledPreviewParameterProvider<ArtistInfoLayoutUIData>() {

    override val labeledValues = listOf(
        "Default" to provide()
    )

    fun provide(): ArtistInfoLayoutUIData {
        return ArtistInfoLayoutUIData(
            name = "Artist",
            iconUrl = "",
        )
    }
}