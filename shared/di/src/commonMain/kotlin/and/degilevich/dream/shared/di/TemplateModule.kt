package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.template.component.impl.di.templateComponentModule
import org.koin.dsl.module

internal fun templateModule() = module {
    includes(templateComponentModule())
}