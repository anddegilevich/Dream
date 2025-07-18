package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

internal class AlbumDetailsExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<AlbumDetailsState, AlbumDetailsIntent, AlbumDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val fetchAlbumUseCase: FetchAlbumUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchAlbum()
        }
    }

    private fun fetchAlbum() {
        scope.launch {
            setLoading(true)
            val params = GetAlbumParams(
                id = state().navArgs.albumId
            )
            withContext(context = Dispatchers.IO) { fetchAlbumUseCase(params = params) }
                .onSuccess { result ->
                    setAlbum(album = result.album)
                }
            setLoading(false)
        }
    }

    private fun setAlbum(album: AlbumData) {
        reduce { copy(album = album) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }
}