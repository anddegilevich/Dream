package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import com.arkivanov.mvikotlin.core.store.Store

internal interface SearchStore : Store<SearchIntent, SearchState, SearchSideEffect>