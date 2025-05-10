package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.ComponentStoreFactoryTemplate

internal class ArtistDetailsStoreFactory : ComponentStoreFactoryTemplate<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect
    >(
    storeName = ArtistDetailsStore::class.className(),
    executorFactory = { lifecycle -> ArtistDetailsExecutor(lifecycle = lifecycle) }
)