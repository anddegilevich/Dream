package and.degilevich.dream.shared.core.db.api.entity.crossRef

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = ArtistToAlbumCrossRefEntity.TABLE_NAME,
    primaryKeys = [
        ArtistToAlbumCrossRefEntity.ARTIST_ID,
        ArtistToAlbumCrossRefEntity.ALBUM_ID
    ],
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = [ArtistEntity.ID],
            childColumns = [ArtistToAlbumCrossRefEntity.ARTIST_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = [AlbumEntity.ID],
            childColumns = [ArtistToAlbumCrossRefEntity.ALBUM_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ArtistToAlbumCrossRefEntity(

    @ColumnInfo(name = ARTIST_ID)
    val artistId: String,

    @ColumnInfo(name = ALBUM_ID)
    val albumId: String,
) {

    internal companion object {
        const val TABLE_NAME: String = "artists_to_albums"
        const val ARTIST_ID: String = "artist_id"
        const val ALBUM_ID: String = "album_id"
    }
}