package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class AlbumReleasesDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<AlbumReleasesState, AlbumReleasesIntent, AlbumReleasesSideEffect>(
    componentContext = componentContext,
    stateConservator = AlbumReleasesStateConservator()
) {

    private val fetchNewReleasesUseCase: FetchNewReleasesUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: AlbumReleasesIntent) {
        when (intent) {
            is AlbumReleasesIntent.OnAlbumClicked -> navigateToAlbum(albumId = intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchNewReleases()
        }
    }

    private fun fetchNewReleases() = scope.launch {
        val params = GetNewReleasesParams(
            limit = ALBUM_RELEASES_LIMIT,
            offset = 0
        )
        try {
            setLoading(true)
            withContext(context = Dispatchers.IO) { fetchNewReleasesUseCase(params) }
                .onSuccess { result ->
                    setReleases(albums = result.albums.albums)
                }
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::fetchNewReleases
                    )
                }
        } finally {
            setLoading(false)
        }
    }

    private fun navigateToAlbum(albumId: String) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.AlbumDetails(
                navArgs = AlbumDetailsNavArgs(
                    albumId = albumId
                )
            )
        )
    }

    private fun setReleases(albums: List<AlbumSimplifiedData>) = reduce {
        copy(releases = albums)
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private companion object {
        const val ALBUM_RELEASES_LIMIT = 10
    }
}