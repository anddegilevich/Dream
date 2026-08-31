package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.AlbumDao
import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumDao(
    private val onUpsert: (AlbumEntity) -> Unit = { fakeImplementationError() },
    private val onUpsertAll: (List<AlbumEntity>) -> Unit = { fakeImplementationError() },
    private val onDeleteAll: () -> Unit = { fakeImplementationError() }
) : AlbumDao {

    override suspend fun upsert(entity: AlbumEntity) {
        onUpsert(entity)
    }

    override suspend fun upsertAll(entities: List<AlbumEntity>) {
        onUpsertAll(entities)
    }

    override suspend fun deleteAll() {
        onDeleteAll()
    }
}