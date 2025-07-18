package and.degilevich.dream.shared.template.source.impl.local

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseLocalDataSource : KoinComponent {
    protected val database: AppDatabase by inject()

    protected fun <T> T?.foldNullableEntity(): Result<T> {
        return this?.let {
            Result.success(it)
        } ?: Result.failure(NullPointerException("Null query response"))
    }
}