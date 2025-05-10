package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.artist.design.api.di.artistDesignModule
import and.degilevich.dream.shared.feature.artist.model.artifact.impl.di.artistModelArtifactModule
import and.degilevich.dream.shared.feature.artist.model.core.impl.di.artistModelCoreModule
import and.degilevich.dream.shared.feature.artist.source.impl.di.artistSourceModule
import org.koin.dsl.module

internal fun artistModule() = module {
    includes(artistModelArtifactModule())
    includes(artistModelCoreModule())
    includes(artistSourceModule())
    includes(artistDesignModule())
}