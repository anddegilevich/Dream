package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.common.component.mvi.storeFactory.AbstractComponentStoreFactory
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.ArtistListExecutor
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.ArtistListReducer
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListMessage
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistListStoreFactory(
    storeFactory: StoreFactory
) : AbstractComponentStoreFactory<ArtistListState, ArtistListIntent, ArtistListSideEffect, ArtistListMessage>(
    storeFactory = storeFactory,
    executorFactory = { lifecycle -> ArtistListExecutor(lifecycle = lifecycle) },
    reducer = ArtistListReducer(),
)