package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.track.data.mapper.impl.di.trackDataMapperModule
import and.degilevich.dream.shared.feature.track.domain.impl.di.trackDomainModule
import and.degilevich.dream.shared.feature.track.data.impl.di.trackDataModule
import and.degilevich.dream.shated.feature.track.ui.impl.di.trackUiModule
import org.koin.dsl.module

internal fun trackModule() = module {
    includes(trackDataMapperModule())
    includes(trackDataModule())
    includes(trackDomainModule())
    includes(trackUiModule())
}