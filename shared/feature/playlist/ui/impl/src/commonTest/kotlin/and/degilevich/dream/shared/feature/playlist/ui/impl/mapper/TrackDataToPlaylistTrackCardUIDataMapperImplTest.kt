package and.degilevich.dream.shared.feature.playlist.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import and.degilevich.dream.shated.feature.track.ui.test.mapper.FakeTrackInfoToTrackCardInfoUIDataMapper
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackDataToPlaylistTrackCardUIDataMapperImplTest {

    @Test
    fun `map - multiple album images - albumCoverUrl uses the first image`() {
        val track = trackData(
            id = "track-1",
            trackNumber = 3,
            album = simplifiedAlbumData(
                id = "album-1",
                images = listOf(
                    imageData(url = "https://first.image"),
                    imageData(url = "https://second.image")
                )
            )
        )
        val info = TrackCardInfoUIData(
            name = "Track track-1",
            artists = "Artist artist-a"
        )

        val result = createMapper(info = info).map(track)

        with(result) {
            id shouldBe track.id
            number shouldBe "3"
            this.info shouldBe info
            albumCoverUrl shouldBe "https://first.image"
        }
    }

    @Test
    fun `map - album without images - albumCoverUrl is empty`() {
        val track = trackData(
            id = "track-1",
            album = simplifiedAlbumData(
                id = "album-1",
                images = emptyList()
            )
        )

        val result = createMapper().map(track)

        result.albumCoverUrl shouldBe ""
    }

    private fun createMapper(
        info: TrackCardInfoUIData = TrackCardInfoUIData.empty()
    ) = TrackDataToPlaylistTrackCardUIDataMapperImpl(
        trackInfoToTrackCardInfoUIDataMapper = FakeTrackInfoToTrackCardInfoUIDataMapper(onMap = { info })
    )
}
