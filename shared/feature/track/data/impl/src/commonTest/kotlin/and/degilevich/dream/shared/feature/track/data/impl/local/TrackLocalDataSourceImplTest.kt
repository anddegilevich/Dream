package and.degilevich.dream.shared.feature.track.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.core.db.test.dao.FakeAlbumDao
import and.degilevich.dream.shared.core.db.test.dao.FakeArtistDao
import and.degilevich.dream.shared.core.db.test.dao.FakeArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.test.dao.FakeArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.test.dao.FakeTrackDao
import and.degilevich.dream.shared.core.db.test.database.FakeAppDatabase
import and.degilevich.dream.shared.core.db.test.entity.albumEntity
import and.degilevich.dream.shared.core.db.test.entity.artistEntity
import and.degilevich.dream.shared.core.db.test.entity.trackEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.local.FakeSimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.local.FakeSimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.local.FakeTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TrackLocalDataSourceImplTest {

    @Test
    fun `saveTrack - single track - upserts track album artist and cross ref entities`() = runTest {
        val trackUpserted = mutableListOf<TrackEntity>()
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val albumUpserted = mutableListOf<AlbumEntity>()
        val artistToAlbumUpsertedAll = mutableListOf<List<ArtistToAlbumCrossRefEntity>>()
        val artistToTrackUpsertedAll = mutableListOf<List<ArtistToTrackCrossRefEntity>>()
        val dataSource = createDataSource(
            trackDao = FakeTrackDao(onUpsert = { trackUpserted.add(it) }),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            albumDao = FakeAlbumDao(onUpsert = { albumUpserted.add(it) }),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(
                onUpsertAll = { artistToAlbumUpsertedAll.add(it) }
            ),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(
                onUpsertAll = { artistToTrackUpsertedAll.add(it) }
            )
        )
        val artist = simplifiedArtistData(id = "artist-a")
        val album = simplifiedAlbumData(
            id = "album-1",
            artists = listOf(artist)
        )
        val track = trackData(
            id = "track-1",
            album = album,
            artists = listOf(artist)
        )
        dataSource.saveTrack(track)
        trackUpserted shouldBe listOf(
            trackEntity(
                id = "track-1",
                albumId = "album-1"
            )
        )
        artistUpsertedAll.single() shouldBe listOf(
            artistEntity(id = "artist-a")
        )
        albumUpserted shouldBe listOf(
            albumEntity(id = "album-1")
        )
        artistToAlbumUpsertedAll.single() shouldBe listOf(
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-a",
                albumId = "album-1"
            )
        )
        artistToTrackUpsertedAll.single() shouldBe listOf(
            ArtistToTrackCrossRefEntity(
                artistId = "artist-a",
                trackId = "track-1"
            )
        )
    }

    @Test
    fun `saveTracks - multiple tracks sharing artist and album - dedupes artist and album upserts`() = runTest {
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val albumUpsertedAll = mutableListOf<List<AlbumEntity>>()
        val dataSource = createDataSource(
            trackDao = FakeTrackDao(onUpsertAll = {}),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            albumDao = FakeAlbumDao(onUpsertAll = { albumUpsertedAll.add(it) }),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(onUpsertAll = {}),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(onUpsertAll = {})
        )
        val artist = simplifiedArtistData(id = "artist-a")
        val album = simplifiedAlbumData(
            id = "album-1",
            artists = listOf(artist)
        )
        val tracks = listOf(
            trackData(
                id = "track-1",
                album = album,
                artists = listOf(artist)
            ),
            trackData(
                id = "track-2",
                album = album,
                artists = listOf(artist)
            )
        )
        dataSource.saveTracks(tracks)
        artistUpsertedAll.single() shouldBe listOf(artistEntity(id = "artist-a"))
        albumUpsertedAll.single() shouldBe listOf(albumEntity(id = "album-1"))
    }

    @Test
    fun `saveTrack - album artist not among track artists - upserts album artist too`() = runTest {
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val artistToAlbumUpsertedAll = mutableListOf<List<ArtistToAlbumCrossRefEntity>>()
        val dataSource = createDataSource(
            trackDao = FakeTrackDao(onUpsert = {}),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            albumDao = FakeAlbumDao(onUpsert = {}),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(
                onUpsertAll = { artistToAlbumUpsertedAll.add(it) }
            ),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(onUpsertAll = {})
        )
        val trackArtist = simplifiedArtistData(id = "artist-a")
        val albumArtist = simplifiedArtistData(id = "artist-b")
        val track = trackData(
            id = "track-1",
            album = simplifiedAlbumData(
                id = "album-1",
                artists = listOf(albumArtist)
            ),
            artists = listOf(trackArtist)
        )
        dataSource.saveTrack(track)
        artistUpsertedAll.single() shouldBe listOf(
            artistEntity(id = "artist-a"),
            artistEntity(id = "artist-b")
        )
        artistToAlbumUpsertedAll.single() shouldBe listOf(
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-b",
                albumId = "album-1"
            )
        )
    }

    @Test
    fun `saveTracks - album artist not among track artists - upserts album artist too`() = runTest {
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val artistToAlbumUpsertedAll = mutableListOf<List<ArtistToAlbumCrossRefEntity>>()
        val dataSource = createDataSource(
            trackDao = FakeTrackDao(onUpsertAll = {}),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            albumDao = FakeAlbumDao(onUpsertAll = {}),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(
                onUpsertAll = { artistToAlbumUpsertedAll.add(it) }
            ),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(onUpsertAll = {})
        )
        val trackArtist = simplifiedArtistData(id = "artist-a")
        val albumArtist = simplifiedArtistData(id = "artist-b")
        val tracks = listOf(
            trackData(
                id = "track-1",
                album = simplifiedAlbumData(
                    id = "album-1",
                    artists = listOf(albumArtist)
                ),
                artists = listOf(trackArtist)
            )
        )
        dataSource.saveTracks(tracks)
        artistUpsertedAll.single() shouldBe listOf(
            artistEntity(id = "artist-a"),
            artistEntity(id = "artist-b")
        )
        artistToAlbumUpsertedAll.single() shouldBe listOf(
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-b",
                albumId = "album-1"
            )
        )
    }

    private fun createDataSource(
        trackDao: TrackDao = FakeTrackDao(),
        artistDao: ArtistDao = FakeArtistDao(),
        albumDao: AlbumDao = FakeAlbumDao(),
        artistToAlbumCrossRefDao: ArtistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(),
        artistToTrackCrossRefDao: ArtistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(),
        trackDataToEntityMapper: TrackDataToEntityMapper = FakeTrackDataToEntityMapper(onMap = ::toTrackEntity),
        simplifiedArtistDataToEntityMapper: SimplifiedArtistDataToEntityMapper =
            FakeSimplifiedArtistDataToEntityMapper(onMap = ::toArtistEntity),
        simplifiedAlbumDataToEntityMapper: SimplifiedAlbumDataToEntityMapper =
            FakeSimplifiedAlbumDataToEntityMapper(onMap = ::toAlbumEntity)
    ) = TrackLocalDataSourceImpl(
        database = FakeAppDatabase(
            onGetTrackDao = { trackDao },
            onGetArtistDao = { artistDao },
            onGetAlbumDao = { albumDao },
            onGetArtistToAlbumCrossRefDao = { artistToAlbumCrossRefDao },
            onGetArtistToTrackCrossRefDao = { artistToTrackCrossRefDao }
        ),
        trackDataToEntityMapper = trackDataToEntityMapper,
        simplifiedArtistDataToEntityMapper = simplifiedArtistDataToEntityMapper,
        simplifiedAlbumDataToEntityMapper = simplifiedAlbumDataToEntityMapper
    )

    private fun toTrackEntity(item: TrackData) = TrackEntity(
        id = item.id.value,
        name = item.name,
        albumId = item.album.id.value,
        trackNumber = item.trackNumber,
        durationMs = item.durationMs
    )

    private fun toArtistEntity(item: SimplifiedArtistData) = ArtistEntity(
        id = item.id.value,
        name = item.name,
        artistType = item.artistType.id.value
    )

    private fun toAlbumEntity(item: SimplifiedAlbumData) = AlbumEntity(
        id = item.id.value,
        name = item.name,
        albumType = item.albumType.id.value,
        totalTracks = item.totalTracks,
        releaseDate = item.releaseDate
    )
}
