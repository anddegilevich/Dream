package and.degilevich.dream.shared.di

import android.content.Context
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

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