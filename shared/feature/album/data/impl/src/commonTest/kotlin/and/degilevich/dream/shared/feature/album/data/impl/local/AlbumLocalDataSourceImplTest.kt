package and.degilevich.dream.shared.feature.album.data.impl.local

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
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.local.FakeAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.local.FakeSimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.model.core.test.data.albumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.local.FakeSimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.SimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.local.FakeSimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.SimplifiedTrackData
import and.degilevich.dream.shared.feature.track.model.artifact.test.data.simplifiedTrackData
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class AlbumLocalDataSourceImplTest {

    @Test
    fun `saveAlbum - artist shared between album and track level - dedupes artist upsert`() = runTest {
        val albumUpserted = mutableListOf<AlbumEntity>()
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val dataSource = createDataSource(
            albumDao = FakeAlbumDao(onUpsert = { albumUpserted.add(it) }),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            trackDao = FakeTrackDao(onUpsertAll = {}),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(onUpsertAll = {}),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(onUpsertAll = {})
        )
        val artistA = simplifiedArtistData(id = "artist-a")
        val artistB = simplifiedArtistData(id = "artist-b")
        val album = albumData(
            id = "album-1",
            totalTracks = 2,
            artists = listOf(artistA),
            tracks = AlbumTracksData(
                items = listOf(
                    simplifiedTrackData(
                        id = "track-1",
                        artists = listOf(artistB)
                    ),
                    simplifiedTrackData(
                        id = "track-2",
                        artists = listOf(artistA)
                    )
                )
            )
        )
        dataSource.saveAlbum(album)
        albumUpserted shouldBe listOf(
            albumEntity(
                id = "album-1",
                totalTracks = 2
            )
        )
        artistUpsertedAll.single() shouldContainExactlyInAnyOrder listOf(
            artistEntity(id = "artist-a"),
            artistEntity(id = "artist-b")
        )
    }

    @Test
    fun `saveAlbum - tracks - stamps album id onto every track entity`() = runTest {
        val trackUpsertedAll = mutableListOf<List<TrackEntity>>()
        val dataSource = createDataSource(
            albumDao = FakeAlbumDao(onUpsert = {}),
            artistDao = FakeArtistDao(onUpsertAll = {}),
            trackDao = FakeTrackDao(onUpsertAll = { trackUpsertedAll.add(it) }),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(onUpsertAll = {}),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(onUpsertAll = {})
        )
        val album = albumData(
            id = "album-1",
            tracks = AlbumTracksData(
                items = listOf(
                    simplifiedTrackData(
                        id = "track-1",
                        artists = emptyList()
                    )
                )
            )
        )
        dataSource.saveAlbum(album)
        trackUpsertedAll.single() shouldBe listOf(
            trackEntity(
                id = "track-1",
                albumId = "album-1"
            )
        )
    }

    @Test
    fun `saveAlbum - cross refs - builds artist-album and artist-track refs`() = runTest {
        val artistToAlbumUpsertedAll = mutableListOf<List<ArtistToAlbumCrossRefEntity>>()
        val artistToTrackUpsertedAll = mutableListOf<List<ArtistToTrackCrossRefEntity>>()
        val dataSource = createDataSource(
            albumDao = FakeAlbumDao(onUpsert = {}),
            artistDao = FakeArtistDao(onUpsertAll = {}),
            trackDao = FakeTrackDao(onUpsertAll = {}),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(
                onUpsertAll = { artistToAlbumUpsertedAll.add(it) }
            ),
            artistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(
                onUpsertAll = { artistToTrackUpsertedAll.add(it) }
            )
        )
        val artistA = simplifiedArtistData(id = "artist-a")
        val artistB = simplifiedArtistData(id = "artist-b")
        val album = albumData(
            id = "album-1",
            artists = listOf(artistA),
            tracks = AlbumTracksData(
                items = listOf(
                    simplifiedTrackData(
                        id = "track-1",
                        artists = listOf(artistB)
                    )
                )
            )
        )
        dataSource.saveAlbum(album)
        artistToAlbumUpsertedAll.single() shouldBe listOf(
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-a",
                albumId = "album-1"
            )
        )
        artistToTrackUpsertedAll.single() shouldBe listOf(
            ArtistToTrackCrossRefEntity(
                artistId = "artist-b",
                trackId = "track-1"
            )
        )
    }

    @Test
    fun `saveAlbums - simplified albums - upserts albums artists and artist-album refs only`() = runTest {
        val albumUpsertedAll = mutableListOf<List<AlbumEntity>>()
        val artistUpsertedAll = mutableListOf<List<ArtistEntity>>()
        val artistToAlbumUpsertedAll = mutableListOf<List<ArtistToAlbumCrossRefEntity>>()
        val dataSource = createDataSource(
            albumDao = FakeAlbumDao(onUpsertAll = { albumUpsertedAll.add(it) }),
            artistDao = FakeArtistDao(onUpsertAll = { artistUpsertedAll.add(it) }),
            artistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(
                onUpsertAll = { artistToAlbumUpsertedAll.add(it) }
            )
        )
        val artistA = simplifiedArtistData(id = "artist-a")
        val albums = listOf(
            simplifiedAlbumData(
                id = "album-1",
                artists = listOf(artistA)
            ),
            simplifiedAlbumData(
                id = "album-2",
                artists = listOf(artistA)
            )
        )
        dataSource.saveAlbums(albums)
        albumUpsertedAll.single() shouldBe albums.map { albumEntity(id = it.id.value) }
        artistUpsertedAll.single() shouldBe listOf(
            artistEntity(id = "artist-a"),
            artistEntity(id = "artist-a")
        )
        artistToAlbumUpsertedAll.single() shouldBe listOf(
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-a",
                albumId = "album-1"
            ),
            ArtistToAlbumCrossRefEntity(
                artistId = "artist-a",
                albumId = "album-2"
            )
        )
    }

    private fun createDataSource(
        albumDao: AlbumDao = FakeAlbumDao(),
        artistDao: ArtistDao = FakeArtistDao(),
        trackDao: TrackDao = FakeTrackDao(),
        artistToAlbumCrossRefDao: ArtistToAlbumCrossRefDao = FakeArtistToAlbumCrossRefDao(),
        artistToTrackCrossRefDao: ArtistToTrackCrossRefDao = FakeArtistToTrackCrossRefDao(),
        albumDataToEntityMapper: AlbumDataToEntityMapper = FakeAlbumDataToEntityMapper(onMap = ::toAlbumEntity),
        simplifiedAlbumDataToEntityMapper: SimplifiedAlbumDataToEntityMapper =
            FakeSimplifiedAlbumDataToEntityMapper(onMap = ::toAlbumEntity),
        simplifiedArtistDataToEntityMapper: SimplifiedArtistDataToEntityMapper =
            FakeSimplifiedArtistDataToEntityMapper(onMap = ::toArtistEntity),
        simplifiedTrackDataToEntityMapper: SimplifiedTrackDataToEntityMapper =
            FakeSimplifiedTrackDataToEntityMapper(onMap = ::toTrackEntity)
    ) = AlbumLocalDataSourceImpl(
        database = FakeAppDatabase(
            onGetArtistDao = { artistDao },
            onGetAlbumDao = { albumDao },
            onGetTrackDao = { trackDao },
            onGetArtistToAlbumCrossRefDao = { artistToAlbumCrossRefDao },
            onGetArtistToTrackCrossRefDao = { artistToTrackCrossRefDao }
        ),
        albumDataToEntityMapper = albumDataToEntityMapper,
        simplifiedAlbumDataToEntityMapper = simplifiedAlbumDataToEntityMapper,
        simplifiedArtistDataToEntityMapper = simplifiedArtistDataToEntityMapper,
        simplifiedTrackDataToEntityMapper = simplifiedTrackDataToEntityMapper
    )

    private fun toAlbumEntity(item: AlbumData) = AlbumEntity(
        id = item.id.value,
        name = item.name,
        albumType = item.albumType.id.value,
        totalTracks = item.totalTracks,
        releaseDate = item.releaseDate
    )

    private fun toAlbumEntity(item: SimplifiedAlbumData) = AlbumEntity(
        id = item.id.value,
        name = item.name,
        albumType = item.albumType.id.value,
        totalTracks = item.totalTracks,
        releaseDate = item.releaseDate
    )

    private fun toArtistEntity(item: SimplifiedArtistData) = ArtistEntity(
        id = item.id.value,
        name = item.name,
        artistType = item.artistType.id.value
    )

    private fun toTrackEntity(item: SimplifiedTrackData) = TrackEntity(
        id = item.id.value,
        name = item.name,
        albumId = null,
        trackNumber = item.trackNumber,
        durationMs = item.durationMs
    )
}
