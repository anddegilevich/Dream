package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.logger.DILogger
import org.koin.core.context.startKoin

fun initDI() {
    startKoin {
        logger(DILogger())
        modules(appModule())
    }
}