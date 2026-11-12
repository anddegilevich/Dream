package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.preview

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerUIState
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData

class MiniPlayerUIStatePreviewProvider : LabeledPreviewParameterProvider<MiniPlayerUIState>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Shuffling" to provideShuffling(),
        "Playing" to providePlaying(),
        "Long names" to provideLongNames(),
        "Progress start" to provideProgressStart(),
        "Progress end" to provideProgressEnd()
    )

    fun provideDefault(): MiniPlayerUIState {
        return MiniPlayerUIState(
            coverUrl = "",
            track = TrackCardInfoUIData(
                name = "Track",
                artists = "Artist"
            ),
            progressFraction = 0.25f,
            isShuffling = false,
            isPlaying = false
        )
    }

    fun provideShuffling(): MiniPlayerUIState {
        return provideDefault().copy(isShuffling = true)
    }

    fun providePlaying(): MiniPlayerUIState {
        return provideDefault().copy(isPlaying = true)
    }

    fun provideLongNames(): MiniPlayerUIState {
        return provideDefault().copy(
            track = TrackCardInfoUIData(
                name = "A very long track name that does not fit on a single line",
                artists = "First Artist, Second Artist, Third Artist"
            )
        )
    }

    fun provideProgressStart(): MiniPlayerUIState {
        return provideDefault().copy(progressFraction = 0f)
    }

    fun provideProgressEnd(): MiniPlayerUIState {
        return provideDefault().copy(progressFraction = 1f)
    }
}
