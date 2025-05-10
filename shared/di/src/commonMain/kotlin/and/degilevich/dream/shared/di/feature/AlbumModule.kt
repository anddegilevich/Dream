package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.album.model.artifact.impl.di.albumModelArtifactModule
import org.koin.dsl.module

internal fun albumModule() = module {
    includes(albumModelArtifactModule())
}