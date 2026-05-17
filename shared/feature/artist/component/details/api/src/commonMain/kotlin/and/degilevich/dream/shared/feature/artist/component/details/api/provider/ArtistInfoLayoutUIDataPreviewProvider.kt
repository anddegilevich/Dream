package and.degilevich.dream.shared.feature.artist.component.details.api.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoLayoutUIData
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