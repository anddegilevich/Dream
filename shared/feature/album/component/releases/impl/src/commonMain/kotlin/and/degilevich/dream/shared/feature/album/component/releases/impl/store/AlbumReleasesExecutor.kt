package and.degilevich.dream.shared.feature.album.component.releases.impl.store

import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

internal class AlbumReleasesExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<AlbumReleasesState, AlbumReleasesIntent, AlbumReleasesSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val albumRemoteDataSource: AlbumRemoteDataSource by inject()
    private val toastController: ToastController by inject()
    private val toastFactory: ToastFactory by inject()

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchNewReleases()
        }
    }

    override fun executeIntent(intent: AlbumReleasesIntent) {
        when (intent) {
            is AlbumReleasesIntent.OnAlbumClicked -> navigateToAlbum(albumId = intent.id)
        }
    }

    private fun fetchNewReleases() {
        scope.launch {
            setLoading(true)
            val params = GetNewReleasesParams(
                limit = 10,
                offset = 0
            )
            withContext(context = Dispatchers.IO) { albumRemoteDataSource.getNewReleases(params) }
                .onSuccess { result ->
                    setReleases(albums = result.albums.albums)
                }
                .onFailure { error ->
                    toastController.showToast(
                        toast = toastFactory.createRepeatToast(
                            error = error,
                            onRepeat = ::fetchNewReleases
                        )
                    )
                }
            setLoading(false)
        }
    }

    private fun navigateToAlbum(albumId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.AlbumDetails(
                navArgs = AlbumDetailsNavArgs(
                    albumId = albumId
                )
            )
        )
    }

    private fun setReleases(albums: List<AlbumSimplifiedData>) {
        reduce { copy(releases = albums) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }
}