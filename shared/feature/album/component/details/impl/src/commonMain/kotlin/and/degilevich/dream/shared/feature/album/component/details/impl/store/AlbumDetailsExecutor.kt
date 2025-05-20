package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
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
) : ExecutorAbs<AlbumDetailsState, AlbumDetailsIntent, AlbumDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val albumRemoteDataSource: AlbumRemoteDataSource by inject()

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
            withContext(context = Dispatchers.IO) { albumRemoteDataSource.getAlbum(params = params) }
                .onSuccess { result ->
                    setAlbum(album = result.album)
                }
        }.invokeOnCompletion {
            setLoading(false)
        }
    }

    private fun setAlbum(album: AlbumData) {
        reduce {
            copy(
                album = album
            )
        }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce {
            copy(
                isLoading = isLoading
            )
        }
    }
}