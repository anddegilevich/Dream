package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.album.model.artifact.impl.di.albumModelArtifactModule
import and.degilevich.dream.shared.feature.album.source.impl.di.albumSourceModule
import org.koin.dsl.module

internal fun albumModule() = module {
    includes(albumModelArtifactModule())
    includes(albumSourceModule())
}