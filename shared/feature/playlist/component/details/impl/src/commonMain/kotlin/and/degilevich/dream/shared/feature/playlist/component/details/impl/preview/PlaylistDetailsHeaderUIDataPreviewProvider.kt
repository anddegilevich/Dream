package and.degilevich.dream.shared.feature.playlist.component.details.impl.preview

import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsHeaderUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class PlaylistDetailsHeaderUIDataPreviewProvider : LabeledPreviewParameterProvider<PlaylistDetailsHeaderUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Without description" to provideWithoutDescription()
    )

    fun provideDefault(): PlaylistDetailsHeaderUIData {
        return PlaylistDetailsHeaderUIData(
            coverUrl = "",
            name = "Chill Mix",
            description = "Laid back beats for a slow evening",
            isVisibleDescription = true
        )
    }

    fun provideWithoutDescription(): PlaylistDetailsHeaderUIData {
        return provideDefault().copy(
            description = "",
            isVisibleDescription = false
        )
    }
}
