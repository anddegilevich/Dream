package and.degilevich.dream.shared.core.db.api.relation

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TrackExtendedEntity(

    @Embedded
    val track: TrackEntity,

    @Relation(
        entity = AlbumEntity::class,
        parentColumn = TrackEntity.ALBUM_ID,
        entityColumn = AlbumEntity.ID
    )
    val album: AlbumEntity? = null,

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
    val artists: List<ArtistEntity>? = null
)