package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.artist.core.impl.di.artistCoreModule
import and.degilevich.dream.shared.feature.artist.design.api.di.artistDesignModule
import and.degilevich.dream.shared.feature.artist.model.core.impl.di.artistModelCoreModule
import org.koin.dsl.module

fun artistModule() = module {
    includes(artistModelCoreModule())
    includes(artistCoreModule())
    includes(artistDesignModule())
}