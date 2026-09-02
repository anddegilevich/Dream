package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class SearchComponentFactoryImpl : SearchComponentFactory {

    override fun create(componentContext: ComponentContext): SearchComponent = SearchComponentImpl(
        componentContext = componentContext
    )
}
