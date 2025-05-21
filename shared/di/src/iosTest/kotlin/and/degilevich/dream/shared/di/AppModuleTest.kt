package and.degilevich.dream.shared.di

import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import kotlin.test.Test

actual class AppModuleTest : KoinTest {

    @Test
    actual fun verifyAppModule() {
        koinApplication {
            modules(appModule())
            checkModules() // FIXME: Change to new api when released
        }
    }
}