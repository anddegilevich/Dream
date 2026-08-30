package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.PlaylistDao
import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistDao(
    private val onUpsert: (PlaylistEntity) -> Unit = { fakeImplementationError() },
    private val onUpsertAll: (List<PlaylistEntity>) -> Unit = { fakeImplementationError() },
    private val onDeleteAll: () -> Unit = { fakeImplementationError() }
) : PlaylistDao {

    override suspend fun upsert(entity: PlaylistEntity) {
        onUpsert(entity)
    }

    override suspend fun upsertAll(entities: List<PlaylistEntity>) {
        onUpsertAll(entities)
    }

    override suspend fun deleteAll() {
        onDeleteAll()
    }
}
