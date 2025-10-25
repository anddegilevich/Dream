package and.degilevich.dream.shared.core.datetime.impl.di

import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.DateTimeHelper
import org.koin.dsl.bind
import org.koin.dsl.module

fun datetimeModule() = module {
    single { DateTimeHelper() } bind DateTime::class
}