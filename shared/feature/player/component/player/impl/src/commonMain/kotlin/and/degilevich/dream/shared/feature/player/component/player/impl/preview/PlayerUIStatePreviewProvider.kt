package and.degilevich.dream.shared.feature.player.component.player.impl.preview

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData

class PlayerUIStatePreviewProvider : LabeledPreviewParameterProvider<PlayerUIState>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Shuffling" to provideShuffling(),
        "Long names" to provideLongNames()
    )

    fun provideDefault(): PlayerUIState {
        return PlayerUIState(
            coverUrl = "",
            track = TrackCardInfoUIData(
                name = "Track",
                artists = "Artist"
            ),
            progress = PlaybackProgressUIData(
                fraction = 0.25f,
                elapsed = "0:20",
                remaining = "-1:00"
            ),
            isShuffling = false
        )
    }

    fun provideShuffling(): PlayerUIState {
        return provideDefault().copy(isShuffling = true)
    }

    fun provideLongNames(): PlayerUIState {
        return provideDefault().copy(
            track = TrackCardInfoUIData(
                name = "A very long track name that does not fit on a single line",
                artists = "First Artist, Second Artist, Third Artist"
            )
        )
    }
}
