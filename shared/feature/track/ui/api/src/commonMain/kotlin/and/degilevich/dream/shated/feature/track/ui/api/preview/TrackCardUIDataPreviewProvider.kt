package and.degilevich.dream.shated.feature.track.ui.api.preview

import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Suppress("MagicNumber")
class TrackCardUIDataPreviewProvider : LabeledPreviewParameterProvider<TrackCardUIData>() {

    private val trackCardInfoUIDataPreviewProvider = TrackCardInfoUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): TrackCardUIData {
        return TrackCardUIData(
            id = identifier("id"),
            number = "1",
            info = trackCardInfoUIDataPreviewProvider.provideDefault()
        )
    }

    fun provideList(): ImmutableList<TrackCardUIData> {
        return List(5) { i ->
            TrackCardUIData(
                id = identifier(value = i.toString()),
                number = i.toString(),
                info = trackCardInfoUIDataPreviewProvider.provide(index = i)
            )
        }.toImmutableList()
    }
}
