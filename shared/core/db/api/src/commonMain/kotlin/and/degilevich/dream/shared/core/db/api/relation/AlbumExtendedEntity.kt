package and.degilevich.dream.shared.core.db.api.relation

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class AlbumExtendedEntity(

    @Embedded
    val album: AlbumEntity,

    @Relation(
        entity = ArtistEntity::class,
        parentColumn = AlbumEntity.ID,
        entityColumn = ArtistEntity.ID,
        associateBy = Junction(
            value = ArtistToAlbumCrossRefEntity::class,
            parentColumn = ArtistToAlbumCrossRefEntity.ALBUM_ID,
            entityColumn = ArtistToAlbumCrossRefEntity.ARTIST_ID
        )
    )
    val artists: List<ArtistEntity>? = null,

    @Relation(
        entity = TrackEntity::class,
        parentColumn = AlbumEntity.ID,
        entityColumn = TrackEntity.ALBUM_ID
    )
    val tracks: List<TrackEntity>? = null,
)