package and.degilevich.dream.shared.core.db.api.entity.crossRef

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = ArtistToTrackCrossRefEntity.TABLE_NAME,
    primaryKeys = [
        ArtistToTrackCrossRefEntity.ARTIST_ID,
        ArtistToTrackCrossRefEntity.TRACK_ID
    ],
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = [ArtistEntity.ID],
            childColumns = [ArtistToTrackCrossRefEntity.ARTIST_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TrackEntity::class,
            parentColumns = [TrackEntity.ID],
            childColumns = [ArtistToTrackCrossRefEntity.TRACK_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ArtistToTrackCrossRefEntity(

    @ColumnInfo(name = ARTIST_ID)
    val artistId: String,

    @ColumnInfo(name = TRACK_ID)
    val trackId: String
) {

    internal companion object {
        const val TABLE_NAME: String = "artists_to_tracks"
        const val ARTIST_ID: String = "artist_id"
        const val TRACK_ID: String = "track_id"
    }
}