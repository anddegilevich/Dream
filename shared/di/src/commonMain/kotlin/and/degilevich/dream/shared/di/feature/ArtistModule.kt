package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.artist.design.api.di.artistDesignModule
import and.degilevich.dream.shared.feature.artist.domain.impl.di.artistDomainModule
import and.degilevich.dream.shared.feature.artist.data.impl.di.artistDataModule
import org.koin.dsl.module

internal fun artistModule() = module {
    includes(artistDataModule())
    includes(artistDomainModule())
    includes(artistDesignModule())
}