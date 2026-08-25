package and.degilevich.dream.shared.core.service.impl.session.storage

import and.degilevich.dream.shared.core.service.impl.session.model.PkceData

internal interface PkceStorage {
    suspend fun save(value: PkceData)
    suspend fun read(): PkceData?
    suspend fun clear()
}
