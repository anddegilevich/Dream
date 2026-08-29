package and.degilevich.dream.shared.feature.user.ui.impl.di

import and.degilevich.dream.shared.feature.user.ui.api.mapper.UserDataToAvatarUIDataMapper
import and.degilevich.dream.shared.feature.user.ui.impl.mapper.UserDataToAvatarUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userUIModule() = module {
    factoryOf(::UserDataToAvatarUIDataMapperImpl) bind UserDataToAvatarUIDataMapper::class
}
