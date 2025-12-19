package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoLayoutUIData
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ArtistInfoLayoutUIDataPreviewProvider : PreviewParameterProvider<ArtistInfoLayoutUIData> {

    override val values: Sequence<ArtistInfoLayoutUIData> = sequenceOf(
        provide()
    )

    fun provide(): ArtistInfoLayoutUIData {
        return ArtistInfoLayoutUIData(
            name = "Artist",
            iconUrl = "",
        )
    }
}