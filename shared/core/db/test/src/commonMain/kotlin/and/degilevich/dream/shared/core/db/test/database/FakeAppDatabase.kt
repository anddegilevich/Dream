package and.degilevich.dream.shared.core.db.test.database

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAppDatabase(
    private val onGetArtistDao: () -> ArtistDao = { fakeImplementationError() },
    private val onGetAlbumDao: () -> AlbumDao = { fakeImplementationError() },
    private val onGetTrackDao: () -> TrackDao = { fakeImplementationError() },
    private val onGetArtistToAlbumCrossRefDao: () -> ArtistToAlbumCrossRefDao = { fakeImplementationError() },
    private val onGetArtistToTrackCrossRefDao: () -> ArtistToTrackCrossRefDao = { fakeImplementationError() }
) : AppDatabase {
    override fun getArtistDao(): ArtistDao = onGetArtistDao()
    override fun getAlbumDao(): AlbumDao = onGetAlbumDao()
    override fun getTrackDao(): TrackDao = onGetTrackDao()
    override fun getArtistToAlbumCrossRefDao(): ArtistToAlbumCrossRefDao = onGetArtistToAlbumCrossRefDao()
    override fun getArtistToTrackCrossRefDao(): ArtistToTrackCrossRefDao = onGetArtistToTrackCrossRefDao()
}