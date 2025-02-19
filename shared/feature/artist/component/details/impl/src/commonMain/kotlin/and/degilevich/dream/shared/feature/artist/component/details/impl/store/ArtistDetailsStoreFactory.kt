package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsMessage
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.AbstractComponentStoreFactory
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistDetailsStoreFactory(
    storeFactory: StoreFactory
) : AbstractComponentStoreFactory<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect,
    ArtistDetailsMessage
    >(
    storeKClass = ArtistDetailsStore::class,
    storeFactory = storeFactory,
    executorFactory = { lifecycle -> ArtistDetailsExecutor(lifecycle = lifecycle) },
    reducer = ArtistDetailsReducer(),
)