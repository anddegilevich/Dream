package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactoryAbs
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistListStoreFactory(
    storeFactory: StoreFactory
) : ComponentStoreFactoryAbs<ArtistListState, ArtistListIntent, ArtistListSideEffect>(
    storeName = ArtistListStore::class.className(),
    storeFactory = storeFactory,
    executorFactory = { lifecycle -> ArtistListExecutor(lifecycle = lifecycle) },
)