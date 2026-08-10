package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeSimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedTrackOutputToDataMapperImplTest {

    @Test
    fun `map - scalar and artist fields - delegates to injected mapper and copies scalars`() {
        val simplifiedArtistData = SimplifiedArtistData.empty()
        val mapper = createMapper(
            simplifiedArtistOutputToDataMapper = FakeSimplifiedArtistOutputToDataMapper(
                onMap = { simplifiedArtistData }
            )
        )
        val input = SimplifiedTrackObject(
            id = "track-1",
            name = "Track Name",
            trackNumber = 2,
            durationMs = 3000,
            artists = listOf(SimplifiedArtistObject(), SimplifiedArtistObject())
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe input.id
            name shouldBe input.name
            trackNumber shouldBe input.trackNumber
            durationMs shouldBe input.durationMs
            artists shouldBe listOf(simplifiedArtistData, simplifiedArtistData)
        }
    }

    @Test
    fun `map - no artists - returns empty artists list`() {
        val result = createMapper().map(SimplifiedTrackObject(artists = null))
        result.artists shouldBe emptyList()
    }

    private fun createMapper(
        simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper =
            FakeSimplifiedArtistOutputToDataMapper()
    ) = SimplifiedTrackOutputToDataMapperImpl(
        simplifiedArtistOutputToDataMapper = simplifiedArtistOutputToDataMapper
    )
}
