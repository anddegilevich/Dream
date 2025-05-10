package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.image.model.artifact.impl.di.imageModelArtifactModule
import org.koin.dsl.module

internal fun imageModule() = module {
    includes(imageModelArtifactModule())
}