package and.degilevich.dream.shared.di

import android.content.Context
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify
import kotlin.test.Test

@OptIn(KoinExperimentalAPI::class)
actual class AppModuleTest {

    @Test
    actual fun verifyAppModule() {
        appModule().verify(
            extraTypes = listOf(Context::class)
        )
    }
}