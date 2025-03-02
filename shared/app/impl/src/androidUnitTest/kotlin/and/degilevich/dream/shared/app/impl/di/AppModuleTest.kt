package and.degilevich.dream.shared.app.impl.di

import android.content.Context
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify
import kotlin.test.Test

@OptIn(KoinExperimentalAPI::class)
class AppModuleTest {

    //FIXME: Add verify for iOS
    @Test
    fun checkKoinModule() {
        appModule().verify(
            extraTypes = listOf(Context::class)
        )
    }
}