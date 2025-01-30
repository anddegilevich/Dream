package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.foundation.decompose.component.mvi.storeFactory.AbstractComponentStoreFactory
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListMessage
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistListStoreFactory(
    storeFactory: StoreFactory
) : AbstractComponentStoreFactory<ArtistListState, ArtistListIntent, ArtistListSideEffect, ArtistListMessage>(
    storeKClass = ArtistListStore::class,
    storeFactory = storeFactory,
    executorFactory = { lifecycle -> ArtistListExecutor(lifecycle = lifecycle) },
    reducer = ArtistListReducer(),
)