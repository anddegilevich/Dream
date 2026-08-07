package and.degilevich.dream.shared.feature.artist.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.test.dao.FakeArtistDao
import and.degilevich.dream.shared.core.db.test.database.FakeAppDatabase
import and.degilevich.dream.shared.core.db.test.entity.artistEntity
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.local.FakeArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ArtistLocalDataSourceImplTest {

    @Test
    fun `saveArtist - single artist - upserts mapped entity`() = runTest {
        val upserted = mutableListOf<ArtistEntity>()
        val dataSource = createDataSource(
            artistDao = FakeArtistDao(onUpsert = { upserted.add(it) })
        )
        val artist = artistData(id = "artist-1")
        dataSource.saveArtist(artist)
        upserted shouldBe listOf(artistEntity(id = "artist-1"))
    }

    @Test
    fun `saveArtists - multiple artists - upserts all mapped entities`() = runTest {
        val upsertedAll = mutableListOf<List<ArtistEntity>>()
        val dataSource = createDataSource(
            artistDao = FakeArtistDao(onUpsertAll = { upsertedAll.add(it) })
        )
        val artists = listOf(
            artistData(id = "artist-1"),
            artistData(id = "artist-2")
        )
        dataSource.saveArtists(artists)
        upsertedAll.single() shouldBe artists.map { artistEntity(id = it.id.value) }
    }

    private fun createDataSource(
        artistDao: ArtistDao = FakeArtistDao(),
        artistDataToEntityMapper: ArtistDataToEntityMapper = FakeArtistDataToEntityMapper(onMap = ::toArtistEntity)
    ) = ArtistLocalDataSourceImpl(
        database = FakeAppDatabase(onGetArtistDao = { artistDao }),
        artistDataToEntityMapper = artistDataToEntityMapper
    )

    private fun toArtistEntity(item: ArtistData) = ArtistEntity(
        id = item.id.value,
        name = item.name,
        artistType = item.artistType.id.value
    )
}
