package and.degilevich.dream.shared.feature.search.component.search.api.component

import com.arkivanov.decompose.ComponentContext

interface SearchComponentFactory {

    fun create(componentContext: ComponentContext): SearchComponent
}
