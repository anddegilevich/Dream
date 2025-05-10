package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.track.model.artifact.impl.di.trackModelArtifactModule
import and.degilevich.dream.shared.feature.track.model.core.impl.di.trackModelCoreModule
import org.koin.dsl.module

internal fun trackModule() = module {
    includes(trackModelArtifactModule())
    includes(trackModelCoreModule())
}