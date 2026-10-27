package and.degilevich.dream.shared.feature.player.ui.impl.mapper

import and.degilevich.dream.shared.core.datetime.api.DreamDateTimeFormat
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.ui.api.mapper.PlaybackStateDataToPlaybackProgressUIDataMapper
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import kotlin.time.Duration.Companion.hours

internal class PlaybackStateDataToPlaybackProgressUIDataMapperImpl(
    private val dateTime: DateTime
) : PlaybackStateDataToPlaybackProgressUIDataMapper {

    override fun map(item: PlaybackStateData): PlaybackProgressUIData = with(item) {
        val remainingMs = (track.durationMs - progressMs).coerceAtLeast(0)
        PlaybackProgressUIData(
            fraction = progressFraction(progressMs = progressMs, durationMs = track.durationMs),
            elapsed = formatPlaybackTime(millis = progressMs.toLong()),
            remaining = "-" + formatPlaybackTime(millis = remainingMs.toLong())
        )
    }

    private fun progressFraction(progressMs: Int, durationMs: Int): Float {
        if (durationMs <= 0) return 0f
        return (progressMs.toFloat() / durationMs).coerceIn(0f, 1f)
    }

    private fun formatPlaybackTime(millis: Long): String = dateTime.formatter.format {
        setInput(DateTimeInput.FromMillis(millis = millis))
        setConvertToLocal(false)
        setOutputFormat(
            format = if (millis < HOUR.inWholeMilliseconds) {
                DreamDateTimeFormat.M_SS
            } else {
                DreamDateTimeFormat.H_MM_SS
            }
        )
    }

    private companion object {
        val HOUR = 1.hours
    }
}
