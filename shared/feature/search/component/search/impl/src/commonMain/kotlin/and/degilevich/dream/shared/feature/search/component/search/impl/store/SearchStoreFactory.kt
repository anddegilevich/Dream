package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class SearchStoreFactory : BaseComponentStoreFactory<
    SearchState,
    SearchIntent,
    SearchSideEffect
    >(
    storeName = SearchStore::class.className(),
    executorFactory = { lifecycle -> SearchExecutor(lifecycle = lifecycle) }
)