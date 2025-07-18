package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.feature.artist.source.api.remote.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistListExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<ArtistListState, ArtistListIntent, ArtistListSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val artistRemoteDataSource: ArtistRemoteDataSource by inject()
    private val toastController: ToastController by inject()
    private val toastFactory: ToastFactory by inject()

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchArtists()
        }
    }

    override fun executeIntent(intent: ArtistListIntent) {
        when (intent) {
            is ArtistListIntent.OnArtistClicked -> navigateToArtist(intent.id)
            ArtistListIntent.OnProfileClicked -> navigateToProfile()
        }
    }

    private fun fetchArtists() {
        scope.launch {
            setLoading(true)
            val params = GetArtistsParams(
                ids = listOf(
                    "2CIMQHirSU0MQqyYHq0eOx",
                    "57dN52uHvrHOxijzpIgu3E",
                    "1vCWHaC5f2uS3yhpwWbIA6"
                )
            )
            withContext(context = Dispatchers.IO) { artistRemoteDataSource.getArtists(params) }
                .onSuccess { result ->
                    setArtists(artists = result.artists)
                }
                .onFailure { error ->
                    toastController.showToast(
                        toast = toastFactory.createRepeatToast(
                            error = error,
                            onRepeat = ::fetchArtists
                        )
                    )
                }
            setLoading(false)
        }
    }

    private fun navigateToArtist(artistId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(
                    artistId = artistId
                )
            )
        )
    }

    private fun navigateToProfile() {
        navigator.screenNavigator.pushNew(ScreenConfig.Profile)
    }

    private fun setArtists(artists: List<ArtistData>) {
        reduce { copy(artists = artists) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }
}