package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.album.component.details.impl.di.albumDetailsComponentModule
import and.degilevich.dream.shared.feature.album.component.releases.impl.di.albumReleasesComponentModule
import and.degilevich.dream.shared.feature.album.data.impl.di.albumDataModule
import and.degilevich.dream.shared.feature.album.data.mapper.impl.di.albumDataMapperModule
import and.degilevich.dream.shared.feature.album.domain.impl.di.albumDomainModule
import and.degilevich.dream.shared.feature.album.ui.impl.di.albumUiModule
import org.koin.dsl.module

internal fun albumModule() = module {
    includes(albumDataMapperModule())
    includes(albumDataModule())
    includes(albumDomainModule())
    includes(albumUiModule())
    includes(albumDetailsComponentModule())
    includes(albumReleasesComponentModule())
}