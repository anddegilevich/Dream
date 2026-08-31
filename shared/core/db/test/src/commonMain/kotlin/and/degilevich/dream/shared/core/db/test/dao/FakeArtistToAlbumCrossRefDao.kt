package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.ArtistToAlbumCrossRefDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistToAlbumCrossRefDao(
    private val onUpsertAll: (List<ArtistToAlbumCrossRefEntity>) -> Unit = { fakeImplementationError() },
    private val onDeleteAll: () -> Unit = { fakeImplementationError() }
) : ArtistToAlbumCrossRefDao {

    override suspend fun upsertAll(entities: List<ArtistToAlbumCrossRefEntity>) {
        onUpsertAll(entities)
    }

    override suspend fun deleteAll() {
        onDeleteAll()
    }
}