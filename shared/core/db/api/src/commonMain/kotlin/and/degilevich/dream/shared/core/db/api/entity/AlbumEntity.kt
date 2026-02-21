package and.degilevich.dream.shared.core.db.api.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AlbumEntity.TABLE_NAME)
data class AlbumEntity(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "album_type")
    val albumType: String? = null,

    @ColumnInfo(name = "total_tracks")
    val totalTracks: Int? = null,

    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null
) {

    internal companion object {
        const val TABLE_NAME: String = "albums"
        const val ID: String = "id"
    }
}