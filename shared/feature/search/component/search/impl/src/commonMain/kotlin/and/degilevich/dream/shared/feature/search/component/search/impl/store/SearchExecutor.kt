package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnStop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.time.Duration.Companion.seconds

internal class SearchExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<SearchState, SearchIntent, SearchSideEffect>(lifecycle),
    KoinComponent {

    private val appNavigator: AppNavigator by inject()
    private val toastController: ToastController by inject()
    private val searchUseCase: SearchUseCase by inject()

    private var searchJob: Job? = null

    init {
        subscribeToLifecycle()
    }

    override fun executeIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnQueryChanged -> onQueryChanged(intent.value)
            is SearchIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnStop {
            setLoading(false)
        }
    }

    private fun onQueryChanged(query: String) {
        setQuery(query)
        searchJob?.cancel()
        searchJob = scope.launch {
            delay(SEARCH_DELAY)
            if (query.isEmpty()) {
                setSearchResult(SearchResult.empty())
            } else {
                search()
            }
        }
    }

    private suspend fun search() {
        setLoading(isLoading = true)
        val params = SearchParams(
            query = state().query,
            limit = SEARCH_LIMIT,
            offset = 0,
            types = listOf(
                SearchType.ALBUM,
                SearchType.ARTIST,
                SearchType.TRACK
            )
        )
        withContext(Dispatchers.IO) { searchUseCase(params) }
            .onSuccess { result ->
                setSearchResult(searchResult = result)
            }
            .onFailure { error ->
                toastController.showMessageToast(error)
            }
        setLoading(isLoading = false)
    }

    private fun onItemClicked(searchItemId: String) {
        with(state().searchResult) {
            when {
                artists.items.ids().contains(searchItemId) -> navigateToArtist(artistId = searchItemId)
                albums.items.ids().contains(searchItemId) -> navigateToAlbum(albumId = searchItemId)
                tracks.items.ids().contains(searchItemId) -> navigateToTrack(trackId = searchItemId)
            }
        }
    }

    private fun navigateToArtist(artistId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(artistId = artistId)
            )
        )
    }

    private fun navigateToAlbum(albumId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.AlbumDetails(
                navArgs = AlbumDetailsNavArgs(albumId = albumId)
            )
        )
    }

    private fun navigateToTrack(trackId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(trackId = trackId)
            )
        )
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }

    private fun setQuery(query: String) {
        reduce { copy(query = query) }
    }

    private fun setSearchResult(searchResult: SearchResult) {
        reduce { copy(searchResult = searchResult) }
    }

    private companion object {
        val SEARCH_DELAY = 1.seconds
        private const val SEARCH_LIMIT = 10
    }
}