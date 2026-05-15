package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.image.data.impl.di.imageDataModule
import org.koin.dsl.module

internal fun imageModule() = module {
    includes(imageDataModule())
}