package and.degilevich.dream

import and.degilevich.dream.shared.app.impl.di.appModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DreamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DreamApplication)
            modules(
                appModule()
            )
        }
    }
}