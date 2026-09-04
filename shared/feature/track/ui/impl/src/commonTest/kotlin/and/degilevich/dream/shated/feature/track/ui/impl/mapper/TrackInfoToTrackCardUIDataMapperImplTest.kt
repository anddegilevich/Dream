package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.test.data.simplifiedTrackData
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import and.degilevich.dream.shated.feature.track.ui.test.mapper.FakeTrackInfoToTrackCardInfoUIDataMapper
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackInfoToTrackCardUIDataMapperImplTest {

    @Test
    fun `map - track - copies id, stringifies track number and delegates info to info mapper`() {
        val track = simplifiedTrackData(
            id = "track-1",
            trackNumber = 3
        )
        val info = TrackCardInfoUIData(
            name = "Track track-1",
            artists = "Artist artist-a"
        )
        val mapper = TrackInfoToTrackCardUIDataMapperImpl(
            trackInfoToTrackCardInfoUIDataMapper = FakeTrackInfoToTrackCardInfoUIDataMapper(onMap = { info })
        )

        val result = mapper.map(track)

        with(result) {
            id shouldBe track.id
            number shouldBe "3"
            this.info shouldBe info
        }
    }
}
