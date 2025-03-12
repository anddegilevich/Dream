package and.degilevich.dream

import and.degilevich.dream.shared.app.impl.di.appModule
import and.degilevich.dream.shared.app.impl.logger.KoinLogger
import and.degilevich.dream.shared.logger.Log
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DreamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initDI()
    }

    private fun initLogger() {
        if (!BuildConfig.DEBUG) return
        Log.init()
    }

    private fun initDI() {
        startKoin {
            androidContext(this@DreamApplication)
            logger(KoinLogger())
            modules(
                appModule()
            )
        }
    }
}