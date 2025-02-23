package and.degilevich.dream.shared.template.source.local

import and.degilevich.dream.shared.core.db.api.database.DreamDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractLocalDataSource : LocalDataSource, KoinComponent {
    protected val database: DreamDatabase by inject()

    protected fun <T> T?.foldNullableEntity(): Result<T> {
        return this?.let {
            Result.success(it)
        } ?: Result.failure(NullPointerException("Null query response"))
    }
}