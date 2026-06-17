package and.degilevich.dream.shared.feature.album.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.SimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.template.data.impl.local.BaseLocalDataSource

internal class AlbumLocalDataSourceImpl(
    private val albumDataToEntityMapper: AlbumDataToEntityMapper,
    private val simplifiedAlbumDataToEntityMapper: SimplifiedAlbumDataToEntityMapper,
    private val simplifiedArtistDataToEntityMapper: SimplifiedArtistDataToEntityMapper,
    private val simplifiedTrackDataToEntityMapper: SimplifiedTrackDataToEntityMapper
) : BaseLocalDataSource(), AlbumLocalDataSource {

    private val albumDao: AlbumDao by lazy { database.getAlbumDao() }
    private val artistDao: ArtistDao by lazy { database.getArtistDao() }
    private val trackDao: TrackDao by lazy { database.getTrackDao() }
    private val artistToAlbumCrossRefDao: ArtistToAlbumCrossRefDao by lazy { database.getArtistToAlbumCrossRefDao() }
    private val artistToTrackCrossRefDao: ArtistToTrackCrossRefDao by lazy { database.getArtistToTrackCrossRefDao() }

    override suspend fun saveAlbum(album: AlbumData) {
        albumDao.upsert(album.mapWith(albumDataToEntityMapper))
        artistDao.upsertAll(
            (album.artists + album.tracks.items.flatMap { track -> track.artists })
                .distinctById()
                .mapWith(simplifiedArtistDataToEntityMapper)

        )
        trackDao.upsertAll(
            album.tracks.items
                .mapWith(simplifiedTrackDataToEntityMapper)
                .map { entity ->
                    entity.copy(albumId = album.id.value)
                }
        )
        artistToAlbumCrossRefDao.upsertAll(
            album.artists.map { artist ->
                ArtistToAlbumCrossRefEntity(
                    artistId = artist.id.value,
                    albumId = album.id.value
                )
            }
        )
        val entities = album.tracks.items.flatMap { track ->
            track.artists.map { artist ->
                ArtistToTrackCrossRefEntity(
                    artistId = artist.id.value,
                    trackId = track.id.value
                )
            }
        }
        print(entities)
        artistToTrackCrossRefDao.upsertAll(
            album.tracks.items.flatMap { track ->
                track.artists.map { artist ->
                    ArtistToTrackCrossRefEntity(
                        artistId = artist.id.value,
                        trackId = track.id.value
                    )
                }
            }
        )
    }

    override suspend fun saveAlbums(albums: List<SimplifiedAlbumData>) {
        albumDao.upsertAll(albums.mapWith(simplifiedAlbumDataToEntityMapper))
        artistDao.upsertAll(
            albums.flatMap { album ->
                album.artists.mapWith(simplifiedArtistDataToEntityMapper)
            }
        )
        artistToAlbumCrossRefDao.upsertAll(
            albums.flatMap { album ->
                album.artists.map { artist ->
                    ArtistToAlbumCrossRefEntity(
                        artistId = artist.id.value,
                        albumId = album.id.value
                    )
                }
            }
        )
    }
}