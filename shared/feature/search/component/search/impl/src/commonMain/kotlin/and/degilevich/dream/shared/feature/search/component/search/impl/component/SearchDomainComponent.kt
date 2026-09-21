package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchState
import and.degilevich.dream.shared.feature.search.domain.api.paging.SearchPagingSource
import and.degilevich.dream.shared.feature.search.domain.api.paging.SearchPagingSourceFactory
import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject
import kotlin.time.Duration.Companion.seconds

internal class SearchDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<
    SearchState,
    SearchIntent,
    SearchSideEffect
    >(
    componentContext = componentContext,
    stateConservator = SearchStateConservator()
) {

    private val searchPagingSourceFactory: SearchPagingSourceFactory by inject()
    private val searchPagingSource: SearchPagingSource = searchPagingSourceFactory.create(
        componentContext = componentContext
    )

    private var searchJob: Job? = null

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.OnQueryChanged -> onQueryChanged(intent.value)
            is SearchIntent.OnNextPageRequested -> loadNextPage()
            is SearchIntent.OnItemClicked -> onItemClicked(intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            subscribeToPagingSource()
        }
    }

    private fun subscribeToPagingSource() = with(searchPagingSource) {
        data.onEach(::setItems).launchIn(scope)
        isLoading.onEach(::setLoading).launchIn(scope)
        errors.onEach(::showError).launchIn(scope)
    }

    private fun onQueryChanged(query: String) {
        setQuery(query)
        searchJob?.cancel()
        searchJob = scope.launch {
            delay(SEARCH_DELAY)
            searchPagingSource.setQuery(query = query)
            if (query.isNotEmpty()) {
                withContext(context = Dispatchers.IO) { searchPagingSource.loadFirstPage() }
            }
        }
    }

    private fun loadNextPage() {
        scope.launch {
            withContext(context = Dispatchers.IO) { searchPagingSource.loadNextPage() }
        }
    }

    private fun onItemClicked(searchItemId: Identifier) {
        when (val item = state().items.getById(id = searchItemId)) {
            is SearchItemData.Artist -> navigateToArtist(artistId = item.artist.id)
            is SearchItemData.Album -> navigateToAlbum(albumId = item.album.id)
            is SearchItemData.Track -> navigateToTrack(trackId = item.track.id)
            null -> Unit
        }
    }

    private suspend fun showError(error: Throwable) {
        toastController.showRepeatToast(
            error = error,
            onRepeat = ::loadNextPage
        )
    }

    private fun navigateToArtist(artistId: ArtistId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(artistId = artistId)
            )
        )
    }

    private fun navigateToAlbum(albumId: AlbumId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.AlbumDetails(
                navArgs = AlbumDetailsNavArgs(albumId = albumId)
            )
        )
    }

    private fun navigateToTrack(trackId: TrackId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(trackId = trackId)
            )
        )
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private fun setQuery(query: String) = reduce {
        copy(query = query)
    }

    private fun setItems(items: List<SearchItemData>) = reduce {
        copy(items = items)
    }

    private companion object {
        val SEARCH_DELAY = 1.seconds
    }
}
