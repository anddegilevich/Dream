package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.ArtistToTrackCrossRefDao
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistToTrackCrossRefDao(
    private val onUpsertAll: (List<ArtistToTrackCrossRefEntity>) -> Unit = { fakeImplementationError() },
    private val onDeleteAll: () -> Unit = { fakeImplementationError() }
) : ArtistToTrackCrossRefDao {

    override suspend fun upsertAll(entities: List<ArtistToTrackCrossRefEntity>) {
        onUpsertAll(entities)
    }

    override suspend fun deleteAll() {
        onDeleteAll()
    }
}