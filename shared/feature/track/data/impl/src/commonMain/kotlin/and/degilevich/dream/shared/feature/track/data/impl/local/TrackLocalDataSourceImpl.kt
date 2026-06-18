package and.degilevich.dream.shared.feature.track.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.template.data.impl.local.BaseLocalDataSource

internal class TrackLocalDataSourceImpl(
    private val trackDataToEntityMapper: TrackDataToEntityMapper,
    private val simplifiedArtistDataToEntityMapper: SimplifiedArtistDataToEntityMapper,
    private val simplifiedAlbumDataToEntityMapper: SimplifiedAlbumDataToEntityMapper
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
                .mapWith(simplifiedArtistDataToEntityMapper)
        )
        albumDao.upsertAll(
            tracks
                .map { track -> track.album }
                .distinctById()
                .mapWith(simplifiedAlbumDataToEntityMapper)
        )
        artistToAlbumCrossRefDao.upsertAll(
            tracks
                .map { track -> track.album }
                .distinctById()
                .flatMap { album ->
                    album.artists.map { artist ->
                        ArtistToAlbumCrossRefEntity(
                            artistId = artist.id.value,
                            albumId = album.id.value
                        )
                    }
                }
        )
        artistToTrackCrossRefDao.upsertAll(
            tracks.flatMap { track ->
                track.artists.map { artist ->
                    ArtistToTrackCrossRefEntity(
                        artistId = artist.id.value,
                        trackId = track.id.value
                    )
                }
            }
        )
    }

    override suspend fun saveTrack(track: TrackData) {
        trackDao.upsert(track.mapWith(trackDataToEntityMapper))
        artistDao.upsertAll(track.artists.mapWith(simplifiedArtistDataToEntityMapper))
        albumDao.upsert(track.album.mapWith(simplifiedAlbumDataToEntityMapper))
        artistToAlbumCrossRefDao.upsertAll(
            track.album.artists.map { artist ->
                ArtistToAlbumCrossRefEntity(
                    artistId = artist.id.value,
                    albumId = track.album.id.value
                )
            }
        )
        artistToTrackCrossRefDao.upsertAll(
            track.artists.map { artist ->
                ArtistToTrackCrossRefEntity(
                    artistId = artist.id.value,
                    trackId = track.id.value
                )
            }
        )
    }
}