package and.degilevich.dream.shared.feature.artist.core.impl.di

import and.degilevich.dream.shared.feature.artist.core.api.domain.holder.GetArtistsFilterHolder
import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.impl.domain.GetArtistsFilterHolderImpl
import and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase.GetArtistsFlowUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun artistDomainModule() = module {
    factoryOf(::GetArtistsFlowUseCaseImpl) bind GetArtistsFlowUseCase::class
    factoryOf(::GetArtistsFilterHolderImpl) bind GetArtistsFilterHolder::class
}