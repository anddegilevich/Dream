package and.degilevich.dream.shared.core.db.api.feature.artist.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ArtistFollowersEntity.TABLE_NAME)
data class ArtistFollowersEntity(
    @PrimaryKey
    @ColumnInfo(name = ARTIST_ID)
    val artistId: String,
    val total: Int
) {
    internal companion object {
        const val TABLE_NAME: String = "artist_followers"
        const val ARTIST_ID: String = "artist_id"
    }
}