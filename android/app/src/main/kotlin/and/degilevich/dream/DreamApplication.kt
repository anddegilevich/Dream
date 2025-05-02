package and.degilevich.dream

import and.degilevich.dream.shared.di.appModule
import and.degilevich.dream.shared.di.logger.DILogger
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
            logger(DILogger())
            modules(
                appModule()
            )
        }
    }
}