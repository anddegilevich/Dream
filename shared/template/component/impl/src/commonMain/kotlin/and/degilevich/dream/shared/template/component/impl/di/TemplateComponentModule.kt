package and.degilevich.dream.shared.template.component.impl.di

import and.degilevich.dream.shared.template.component.impl.factory.AppStoreFactory
import com.arkivanov.mvikotlin.core.store.StoreFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun templateComponentModule() = module {
    singleOf(::AppStoreFactory) bind StoreFactory::class
}