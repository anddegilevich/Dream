package and.degilevich.dream.shared.feature.album.component.releases.impl.store

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import com.arkivanov.mvikotlin.core.store.Store

interface AlbumReleasesStore : Store<AlbumReleasesIntent, AlbumReleasesState, AlbumReleasesSideEffect>