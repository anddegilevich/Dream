package and.degilevich.dream.shared.feature.album.source.impl.local

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.source.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.source.api.local.mapper.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.source.api.local.mapper.AlbumSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.template.source.impl.local.BaseLocalDataSource

internal class AlbumLocalDataSourceImpl(
    private val albumDataToEntityMapper: AlbumDataToEntityMapper,
    private val albumSimplifiedDataToEntityMapper: AlbumSimplifiedDataToEntityMapper,
    private val artistSimplifiedDataToEntityMapper: ArtistSimplifiedDataToEntityMapper,
    private val trackSimplifiedDataToEntityMapper: TrackSimplifiedDataToEntityMapper
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
                .mapWith(artistSimplifiedDataToEntityMapper)

        )
        trackDao.upsertAll(
            album.tracks.items
                .mapWith(trackSimplifiedDataToEntityMapper)
                .map { entity ->
                    entity.copy(albumId = album.id.id)
                }
        )
        artistToAlbumCrossRefDao.upsertAll(
            album.artists.map { artist ->
                ArtistToAlbumCrossRefEntity(
                    artistId = artist.id.id,
                    albumId = album.id.id
                )
            }
        )
        val entities = album.tracks.items.flatMap { track ->
            track.artists.map { artist ->
                ArtistToTrackCrossRefEntity(
                    artistId = artist.id.id,
                    trackId = track.id.id
                )
            }
        }
        print(entities)
        artistToTrackCrossRefDao.upsertAll(
            album.tracks.items.flatMap { track ->
                track.artists.map { artist ->
                    ArtistToTrackCrossRefEntity(
                        artistId = artist.id.id,
                        trackId = track.id.id
                    )
                }
            }
        )
    }

    override suspend fun saveAlbums(albums: List<AlbumSimplifiedData>) {
        albumDao.upsertAll(albums.mapWith(albumSimplifiedDataToEntityMapper))
        artistDao.upsertAll(
            albums.flatMap { album ->
                album.artists.mapWith(artistSimplifiedDataToEntityMapper)
            }
        )
        artistToAlbumCrossRefDao.upsertAll(
            albums.flatMap { album ->
                album.artists.map { artist ->
                    ArtistToAlbumCrossRefEntity(
                        artistId = artist.id.id,
                        albumId = album.id.id
                    )
                }
            }
        )
    }
}