package and.degilevich.dream.shared.core.service.api.generated.model

import and.degilevich.dream.shared.core.service.api.generated.infrastructure.ApiClient
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class CurrentlyPlayingContextObjectTest {

    @Test
    fun `decode - epoch millis timestamp - carries the timestamp as Long`() {
        val state = decode(payload = payload(timestamp = "1761571200000"))

        state.timestamp shouldBe 1761571200000L
    }

    @Test
    fun `decode - track item - carries the track`() {
        val state = decode(payload = payload(item = TRACK))

        state.item?.id shouldBe "track-id"
        state.item?.name shouldBe "Track Name"
        state.item?.durationMs shouldBe 80000
        state.item?.artists?.map { it.name } shouldBe listOf("Artist Name")
        state.item?.album?.images?.map { it.url } shouldBe listOf("https://image.url")
    }

    @Test
    fun `decode - episode playing without additional types - decodes with no item`() {
        val state = decode(payload = payload(item = "null", currentlyPlayingType = "episode"))

        state.item shouldBe null
        state.currentlyPlayingType shouldBe "episode"
    }

    @Test
    fun `decode - playback fields - carries progress, playing and shuffle flags`() {
        val state = decode(payload = payload())

        state.progressMs shouldBe 20000
        state.isPlaying shouldBe true
        state.shuffleState shouldBe true
        state.device?.name shouldBe "Device Name"
    }

    private fun decode(payload: String): CurrentlyPlayingContextObject {
        return ApiClient.JSON_DEFAULT.decodeFromString(
            deserializer = CurrentlyPlayingContextObject.serializer(),
            string = payload
        )
    }

    private fun payload(
        timestamp: String = "1761571200000",
        item: String = TRACK,
        currentlyPlayingType: String = "track"
    ): String = """
        {
          "device": {"id":"device-id","is_active":true,"name":"Device Name","type":"Smartphone"},
          "repeat_state": "off",
          "shuffle_state": true,
          "context": null,
          "timestamp": $timestamp,
          "progress_ms": 20000,
          "is_playing": true,
          "item": $item,
          "currently_playing_type": "$currentlyPlayingType",
          "actions": {"disallows": {}}
        }
    """.trimIndent()

    private companion object {
        const val TRACK = """
            {
              "album": {
                "album_type": "album", "total_tracks": 1, "available_markets": [],
                "external_urls": {}, "href": "href", "id": "album-id",
                "images": [{"url": "https://image.url", "height": 640, "width": 640}],
                "name": "Album Name", "release_date": "2020", "release_date_precision": "year",
                "type": "album", "uri": "spotify:album:1", "artists": []
              },
              "artists": [{"external_urls": {}, "href": "href", "id": "artist-id", "name": "Artist Name", "type": "artist", "uri": "spotify:artist:1"}],
              "duration_ms": 80000, "explicit": false, "href": "href", "id": "track-id",
              "is_playable": true, "name": "Track Name", "track_number": 1, "type": "track",
              "uri": "spotify:track:1", "is_local": false
            }
        """
    }
}
