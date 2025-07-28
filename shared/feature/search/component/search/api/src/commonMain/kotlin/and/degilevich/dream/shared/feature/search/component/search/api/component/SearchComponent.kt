package and.degilevich.dream.shared.feature.search.component.search.api.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface SearchComponent : MVIComponent<SearchUIState, SearchIntent, SearchSideEffect>