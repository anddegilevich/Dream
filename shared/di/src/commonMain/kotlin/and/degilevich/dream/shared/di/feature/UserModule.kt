package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.user.data.impl.di.userDataModule
import and.degilevich.dream.shared.feature.user.data.mapper.impl.di.userDataMapperModule
import and.degilevich.dream.shared.feature.user.domain.impl.di.userDomainModule
import and.degilevich.dream.shared.feature.user.ui.impl.di.userUIModule
import org.koin.dsl.module

internal fun userModule() = module {
    includes(userDataMapperModule())
    includes(userDataModule())
    includes(userDomainModule())
    includes(userUIModule())
}
