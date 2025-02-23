package and.degilevich.dream.shared.core.db.api.feature.artist.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtistFollowersEntity(
    @PrimaryKey
    val artistId: String,
    val total: Int
)