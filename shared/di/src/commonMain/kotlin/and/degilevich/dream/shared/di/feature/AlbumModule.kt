package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.album.data.mapper.impl.di.albumDataMapperModule
import and.degilevich.dream.shared.feature.album.ui.impl.di.albumUiModule
import and.degilevich.dream.shared.feature.album.domain.impl.di.albumDomainModule
import and.degilevich.dream.shared.feature.album.data.impl.di.albumDataModule
import org.koin.dsl.module

internal fun albumModule() = module {
    includes(albumDataMapperModule())
    includes(albumDataModule())
    includes(albumDomainModule())
    includes(albumUiModule())
}