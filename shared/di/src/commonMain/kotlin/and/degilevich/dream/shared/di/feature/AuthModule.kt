package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.auth.component.login.impl.di.loginComponentModule
import and.degilevich.dream.shared.feature.auth.data.impl.di.authDataModule
import and.degilevich.dream.shared.feature.auth.domain.impl.di.authDomainModule
import org.koin.dsl.module

internal fun authModule() = module {
    includes(authDataModule())
    includes(authDomainModule())
    includes(loginComponentModule())
}
