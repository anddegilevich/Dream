package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.artist.design.api.di.artistDesignModule
import and.degilevich.dream.shared.feature.artist.domain.impl.di.artistDomainModule
import and.degilevich.dream.shared.feature.artist.source.impl.di.artistSourceModule
import org.koin.dsl.module

internal fun artistModule() = module {
    includes(artistSourceModule())
    includes(artistDomainModule())
    includes(artistDesignModule())
}