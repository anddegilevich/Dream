package and.degilevich.dream.shared.app.impl.di

import and.degilevich.dream.shared.app.impl.logger.KoinLogger
import org.koin.core.context.startKoin

fun initDI() {
    startKoin {
        logger(KoinLogger())
        modules(appModule())
    }
}