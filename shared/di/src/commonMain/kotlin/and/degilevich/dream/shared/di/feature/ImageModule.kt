package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.image.source.impl.di.imageSourceModule
import org.koin.dsl.module

internal fun imageModule() = module {
    includes(imageSourceModule())
}