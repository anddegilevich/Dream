package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.album.design.impl.di.albumDesignModule
import and.degilevich.dream.shared.feature.album.domain.impl.di.albumDomainModule
import and.degilevich.dream.shared.feature.album.model.artifact.impl.di.albumModelArtifactModule
import and.degilevich.dream.shared.feature.album.model.core.impl.di.albumModelCoreModule
import and.degilevich.dream.shared.feature.album.source.impl.di.albumSourceModule
import org.koin.dsl.module

internal fun albumModule() = module {
    includes(albumModelArtifactModule())
    includes(albumModelCoreModule())
    includes(albumSourceModule())
    includes(albumDomainModule())
    includes(albumDesignModule())
}