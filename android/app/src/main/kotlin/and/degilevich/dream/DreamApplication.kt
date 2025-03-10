package and.degilevich.dream

import and.degilevich.dream.shared.app.impl.di.appModule
import and.degilevich.dream.shared.app.impl.logger.KoinLogger
import and.degilevich.dream.shared.core.logger.Log
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DreamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initKoin()
    }

    private fun initLogger() {
        Log.init()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DreamApplication)
            logger(KoinLogger())
            modules(
                appModule()
            )
        }
    }
}