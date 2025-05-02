package and.degilevich.dream.shared.core.db.api.feature.artist.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ArtistEntity.TABLE_NAME)
data class ArtistEntity(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,
    val name: String?,
    val artistType: String?,
    val popularity: Int?
) {
    internal companion object {
        const val TABLE_NAME: String = "artist"
        const val ID: String = "id"
    }
}