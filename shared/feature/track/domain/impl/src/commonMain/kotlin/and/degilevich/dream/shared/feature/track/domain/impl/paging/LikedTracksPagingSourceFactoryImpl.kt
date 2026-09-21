package and.degilevich.dream.shared.feature.track.domain.impl.paging

import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSource
import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import com.arkivanov.decompose.ComponentContext

internal class LikedTracksPagingSourceFactoryImpl(
    private val getSavedTracksUseCase: GetSavedTracksUseCase
) : LikedTracksPagingSourceFactory {

    override fun create(componentContext: ComponentContext): LikedTracksPagingSource = LikedTracksPagingSourceImpl(
        componentContext = componentContext,
        getSavedTracksUseCase = getSavedTracksUseCase
    )
}
