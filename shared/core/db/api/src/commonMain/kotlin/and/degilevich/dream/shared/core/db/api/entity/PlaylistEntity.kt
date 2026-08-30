package and.degilevich.dream.shared.core.db.api.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PlaylistEntity.TABLE_NAME)
data class PlaylistEntity(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "total_tracks")
    val totalTracks: Int? = null
) {

    internal companion object {
        const val TABLE_NAME: String = "playlists"
        const val ID: String = "id"
    }
}
