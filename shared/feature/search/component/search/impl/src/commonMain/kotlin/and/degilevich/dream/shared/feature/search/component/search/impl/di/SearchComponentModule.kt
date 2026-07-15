package and.degilevich.dream.shared.feature.search.component.search.impl.di

import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.SearchComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun searchComponentModule() = module {
    factory<SearchComponent> { (componentContext: ComponentContext) ->
        SearchComponentImpl(componentContext = componentContext)
    }
}
