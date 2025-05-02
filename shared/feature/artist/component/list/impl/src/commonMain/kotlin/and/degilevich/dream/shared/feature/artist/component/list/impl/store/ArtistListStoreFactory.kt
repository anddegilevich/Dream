package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.ComponentStoreFactoryTemplate

internal class ArtistListStoreFactory :
    ComponentStoreFactoryTemplate<ArtistListState, ArtistListIntent, ArtistListSideEffect>(
        storeName = ArtistListStore::class.className(),
        executorFactory = { lifecycle -> ArtistListExecutor(lifecycle = lifecycle) },
    )