package and.degilevich.dream.shared.core.db.api.feature.artist.relation

import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistFollowersEntity
import androidx.room.Embedded
import androidx.room.Relation

data class ArtistExtendedEntity(

    @Embedded
    val artist: ArtistEntity,

    @Relation(
        entity = ArtistFollowersEntity::class,
        parentColumn = ArtistEntity.ID,
        entityColumn = ArtistFollowersEntity.ARTIST_ID
    )
    val followers: ArtistFollowersEntity?
)