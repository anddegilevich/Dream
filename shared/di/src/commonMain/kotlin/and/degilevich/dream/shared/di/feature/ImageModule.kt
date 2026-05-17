package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.image.data.mapper.impl.di.imageDataMapperModule
import org.koin.dsl.module

internal fun imageModule() = module {
    includes(imageDataMapperModule())
}