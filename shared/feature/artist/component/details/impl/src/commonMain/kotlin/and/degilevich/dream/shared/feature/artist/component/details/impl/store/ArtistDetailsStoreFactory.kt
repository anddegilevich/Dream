package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactoryAbs
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistDetailsStoreFactory(
    storeFactory: StoreFactory
) : ComponentStoreFactoryAbs<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect
    >(
    storeName = ArtistDetailsStore::class.className(),
    storeFactory = storeFactory,
    executorFactory = { lifecycle -> ArtistDetailsExecutor(lifecycle = lifecycle) }
)