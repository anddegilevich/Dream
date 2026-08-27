package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeSessionStorage(
    private val onSave: (SessionData) -> Unit = { fakeImplementationError() },
    private val onRead: () -> SessionData? = { fakeImplementationError() },
    private val onClear: () -> Unit = { fakeImplementationError() }
) : SessionStorage {

    override suspend fun save(value: SessionData) {
        onSave(value)
    }

    override suspend fun read(): SessionData? {
        return onRead()
    }

    override suspend fun clear() {
        onClear()
    }
}
