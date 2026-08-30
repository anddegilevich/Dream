package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetCurrentUserPlaylistsUseCase
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListIntent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListSideEffect
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class PlaylistListDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<PlaylistListState, PlaylistListIntent, PlaylistListSideEffect>(
    componentContext = componentContext,
    stateConservator = PlaylistListStateConservator()
) {

    private val getCurrentUserPlaylistsUseCase: GetCurrentUserPlaylistsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: PlaylistListIntent) {
        when (intent) {
            is PlaylistListIntent.OnPlaylistClicked -> Unit // FIXME: navigate to playlist details
            is PlaylistListIntent.OnLikedSongsClicked -> Unit // FIXME: navigate to liked songs
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            getPlaylists()
        }
    }

    private fun getPlaylists() = scope.launch {
        val params = GetCurrentUserPlaylistsParams(
            limit = PLAYLISTS_LIMIT,
            offset = 0
        )
        try {
            setLoading(true)
            withContext(context = Dispatchers.IO) { getCurrentUserPlaylistsUseCase(params) }
                .onSuccess { result ->
                    setPlaylists(playlists = result.playlists)
                }
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::getPlaylists
                    )
                }
        } finally {
            setLoading(false)
        }
    }

    private fun setPlaylists(playlists: List<SimplifiedPlaylistData>) = reduce {
        copy(playlists = playlists)
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private companion object {
        const val PLAYLISTS_LIMIT = 10
    }
}
