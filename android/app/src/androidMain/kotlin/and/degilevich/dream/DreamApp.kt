package and.degilevich.dream

import and.degilevich.dream.shared.app.di.appModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DreamApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@DreamApp)
            modules(
                appModule()
            )
        }
    }
}