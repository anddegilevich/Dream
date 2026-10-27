package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.core.service.api.generated.model.DeviceObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun currentlyPlayingContextObject(
    item: TrackObject? = trackObject(),
    isPlaying: Boolean? = true,
    progressMs: Int? = 20000,
    shuffleState: Boolean? = false
): CurrentlyPlayingContextObject = CurrentlyPlayingContextObject(
    device = DeviceObject(
        id = "device-id",
        isActive = true,
        name = "Device Name"
    ),
    repeatState = "off",
    shuffleState = shuffleState,
    timestamp = 1761571200000L,
    progressMs = progressMs,
    isPlaying = isPlaying,
    item = item,
    currentlyPlayingType = "track"
)
