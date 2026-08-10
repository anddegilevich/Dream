package and.degilevich.dream.shared.core.db.test.dao

import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistDao(
    private val onUpsert: (ArtistEntity) -> Unit = { fakeImplementationError() },
    private val onUpsertAll: (List<ArtistEntity>) -> Unit = { fakeImplementationError() }
) : ArtistDao {

    override suspend fun upsert(entity: ArtistEntity) {
        onUpsert(entity)
    }

    override suspend fun upsertAll(entities: List<ArtistEntity>) {
        onUpsertAll(entities)
    }
}