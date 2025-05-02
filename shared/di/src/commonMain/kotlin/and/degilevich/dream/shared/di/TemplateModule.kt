package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.template.component.di.templateComponentModule
import org.koin.dsl.module

fun templateModule() = module {
    includes(templateComponentModule())
}