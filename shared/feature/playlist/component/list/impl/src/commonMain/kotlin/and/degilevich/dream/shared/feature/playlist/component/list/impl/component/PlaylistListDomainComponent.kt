package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetCurrentUserPlaylistsUseCase
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListIntent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListSideEffect
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListState
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pushToFront
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
            is PlaylistListIntent.OnPlaylistClicked -> onPlaylistClicked(id = intent.id)
            is PlaylistListIntent.OnLikedSongsClicked -> navigateToLikedTracks()
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

    private fun onPlaylistClicked(id: Identifier) {
        val playlist = state().playlists.getById(id = id) ?: return
        navigateToPlaylistDetails(playlistId = playlist.id)
    }

    private fun navigateToPlaylistDetails(playlistId: PlaylistId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.PlaylistDetails(
                navArgs = PlaylistDetailsNavArgs(
                    playlistId = playlistId
                )
            )
        )
    }

    private fun navigateToLikedTracks() {
        navigator.screenNavigator.pushToFront(ScreenConfig.LikedTracks)
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
