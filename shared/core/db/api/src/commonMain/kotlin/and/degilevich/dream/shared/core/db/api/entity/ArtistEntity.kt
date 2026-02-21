package and.degilevich.dream.shared.core.db.api.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ArtistEntity.TABLE_NAME)
data class ArtistEntity(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "artist_type")
    val artistType: String? = null
) {

    internal companion object {
        const val TABLE_NAME: String = "artists"
        const val ID: String = "id"
    }
}