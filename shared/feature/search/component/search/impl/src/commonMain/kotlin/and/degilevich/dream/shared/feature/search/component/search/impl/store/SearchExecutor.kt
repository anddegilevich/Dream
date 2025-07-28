package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import com.arkivanov.essenty.lifecycle.Lifecycle
import org.koin.core.component.KoinComponent

internal class SearchExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<SearchState, SearchIntent, SearchSideEffect>(lifecycle),
    KoinComponent {

    override fun executeIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnQueryChanged -> setQuery(intent.value)
        }
    }

    private fun setQuery(query: String) {
        reduce { copy(query = query) }
    }
}