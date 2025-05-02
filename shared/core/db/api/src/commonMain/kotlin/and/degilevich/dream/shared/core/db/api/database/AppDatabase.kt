package and.degilevich.dream.shared.core.db.api.database

import and.degilevich.dream.shared.core.db.api.feature.artist.dao.ArtistDao

interface AppDatabase {
    fun getArtistDao(): ArtistDao
}