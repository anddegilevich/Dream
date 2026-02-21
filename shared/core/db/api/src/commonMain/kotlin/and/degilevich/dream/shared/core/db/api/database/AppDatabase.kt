package and.degilevich.dream.shared.core.db.api.database

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao

interface AppDatabase {
    fun getArtistDao(): ArtistDao
    fun getAlbumDao(): AlbumDao
    fun getTrackDao(): TrackDao
    fun getArtistToAlbumCrossRefDao(): ArtistToAlbumCrossRefDao
    fun getArtistToTrackCrossRefDao(): ArtistToTrackCrossRefDao
}