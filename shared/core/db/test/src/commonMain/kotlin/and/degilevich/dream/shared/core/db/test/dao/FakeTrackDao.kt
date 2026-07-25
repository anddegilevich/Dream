package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.TrackDao
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackDao(
    private val onUpsert: (TrackEntity) -> Unit = { fakeImplementationError() },
    private val onUpsertAll: (List<TrackEntity>) -> Unit = { fakeImplementationError() }
) : TrackDao {

    override suspend fun upsert(entity: TrackEntity) {
        onUpsert(entity)
    }

    override suspend fun upsertAll(entities: List<TrackEntity>) {
        onUpsertAll(entities)
    }
}