package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.ext.coroutine.withBackgroundContext
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistListExecutor(
    lifecycle: Lifecycle
) : ExecutorAbs<ArtistListState, ArtistListIntent, ArtistListSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val artistRemoteDataSource: ArtistRemoteDataSource by inject()
    private val toastController: ToastController by inject()
    private val toastFactory: ToastFactory by inject()
    private val resourceManager: ResourceManager by inject()

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
            is ArtistListIntent.OnArtistClicked -> {
                navigateToArtist(intent.id)
            }

            ArtistListIntent.OnProfileClicked -> {
                navigateToProfile()
            }
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
            withBackgroundContext { artistRemoteDataSource.getArtists(params) }
                .onSuccess { result ->
                    setArtists(artists = result.artists)
                }
                .onFailure {
                    toastController.showToast(
                        toast = toastFactory.createRepeatToast(
                            message = resourceManager.getString(Res.strings.error_fetch_artists),
                            onRepeat = ::fetchArtists
                        )
                    )
                }
        }.invokeOnCompletion {
            setLoading(false)
        }
    }

    private fun setArtists(artists: List<ArtistData>) {
        reduce {
            copy(artists = artists)
        }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce {
            copy(isLoading = isLoading)
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
}