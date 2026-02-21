package and.degilevich.dream.shared.core.db.api.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TrackEntity.TABLE_NAME)
data class TrackEntity(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = ALBUM_ID)
    val albumId: String? = null,

    @ColumnInfo(name = "track_number")
    val trackNumber: Int? = null,

    @ColumnInfo(name = "duration_ms")
    val durationMs: Int? = null
) {

    internal companion object {
        const val TABLE_NAME: String = "tracks"
        const val ID: String = "id"
        const val ALBUM_ID: String = "album_id"
    }
}