package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.artist.component.details.impl.di.artistDetailsComponentModule
import and.degilevich.dream.shared.feature.artist.data.impl.di.artistDataModule
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.di.artistDataMapperModule
import and.degilevich.dream.shared.feature.artist.domain.impl.di.artistDomainModule
import and.degilevich.dream.shared.feature.artist.ui.api.di.artistUiModule
import org.koin.dsl.module

internal fun artistModule() = module {
    includes(artistDataMapperModule())
    includes(artistDataModule())
    includes(artistDomainModule())
    includes(artistUiModule())
    includes(artistDetailsComponentModule())
}