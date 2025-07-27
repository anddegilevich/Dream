package and.degilevich.dream.shared.navigation.impl.di

import and.degilevich.dream.shared.navigation.api.ActiveScreenConfigValueHolder
import and.degilevich.dream.shared.navigation.impl.ActiveScreenConfigValueHolderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun navigationModule() = module {
    singleOf(::ActiveScreenConfigValueHolderImpl) bind ActiveScreenConfigValueHolder::class
}