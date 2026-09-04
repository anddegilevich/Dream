package and.degilevich.dream.shared.feature.track.component.details.impl.di

import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponentFactory
import and.degilevich.dream.shared.feature.track.component.details.impl.component.TrackDetailsComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDetailsComponentModule() = module {
    factoryOf(::TrackDetailsComponentFactoryImpl) bind TrackDetailsComponentFactory::class
}
