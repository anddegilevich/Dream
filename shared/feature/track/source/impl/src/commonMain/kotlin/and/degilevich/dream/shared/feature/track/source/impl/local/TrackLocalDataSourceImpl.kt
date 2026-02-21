package and.degilevich.dream.shared.feature.track.source.impl.local

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.feature.album.source.api.local.mapper.AlbumSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.source.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackDataToEntityMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.template.source.impl.local.BaseLocalDataSource

internal class TrackLocalDataSourceImpl(
    private val trackDataToEntityMapper: TrackDataToEntityMapper,
    private val artistSimplifiedDataToEntityMapper: ArtistSimplifiedDataToEntityMapper,
    private val albumSimplifiedDataToEntityMapper: AlbumSimplifiedDataToEntityMapper
) : BaseLocalDataSource(), TrackLocalDataSource {

    private val trackDao: TrackDao by lazy { database.getTrackDao() }
    private val artistDao: ArtistDao by lazy { database.getArtistDao() }
    private val albumDao: AlbumDao by lazy { database.getAlbumDao() }
    private val artistToAlbumCrossRefDao: ArtistToAlbumCrossRefDao by lazy { database.getArtistToAlbumCrossRefDao() }
    private val artistToTrackCrossRefDao: ArtistToTrackCrossRefDao by lazy { database.getArtistToTrackCrossRefDao() }

    override suspend fun saveTracks(tracks: List<TrackData>) {
        trackDao.upsertAll(tracks.mapWith(trackDataToEntityMapper))
        artistDao.upsertAll(
            tracks
                .flatMap { track -> track.artists }
                .distinctById()
                .mapWith(artistSimplifiedDataToEntityMapper)
        )
        albumDao.upsertAll(
            tracks
                .map { track -> track.album }
                .distinctById()
                .mapWith(albumSimplifiedDataToEntityMapper)
        )
        artistToAlbumCrossRefDao.upsertAll(
            tracks
                .map { track -> track.album }
                .distinctById()
                .flatMap { album ->
                    album.artists.map { artist ->
                        ArtistToAlbumCrossRefEntity(
                            artistId = artist.id.id,
                            albumId = album.id.id
                        )
                    }
                }
        )
        artistToTrackCrossRefDao.upsertAll(
            tracks.flatMap { track ->
                track.artists.map { artist ->
                    ArtistToTrackCrossRefEntity(
                        artistId = artist.id.id,
                        trackId = track.id.id
                    )
                }
            }
        )
    }

    override suspend fun saveTrack(track: TrackData) {
        trackDao.upsert(track.mapWith(trackDataToEntityMapper))
        artistDao.upsertAll(track.artists.mapWith(artistSimplifiedDataToEntityMapper))
        albumDao.upsert(track.album.mapWith(albumSimplifiedDataToEntityMapper))
        artistToAlbumCrossRefDao.upsertAll(
            track.album.artists.map { artist ->
                ArtistToAlbumCrossRefEntity(
                    artistId = artist.id.id,
                    albumId = track.album.id.id
                )
            }
        )
        artistToTrackCrossRefDao.upsertAll(
            track.artists.map { artist ->
                ArtistToTrackCrossRefEntity(
                    artistId = artist.id.id,
                    trackId = track.id.id
                )
            }
        )
    }
}