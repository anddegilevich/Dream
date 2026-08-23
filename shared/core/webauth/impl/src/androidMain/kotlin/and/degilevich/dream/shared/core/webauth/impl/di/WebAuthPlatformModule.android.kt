package and.degilevich.dream.shared.core.webauth.impl.di

import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.impl.launcher.WebAuthLauncherImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun webAuthPlatformModule() = module {
    single {
        WebAuthLauncherImpl(
            application = androidApplication(),
            redirectChannel = get()
        )
    } bind WebAuthLauncher::class
}
