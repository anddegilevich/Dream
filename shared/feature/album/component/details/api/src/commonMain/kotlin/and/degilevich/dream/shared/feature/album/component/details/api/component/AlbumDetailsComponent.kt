package and.degilevich.dream.shared.feature.album.component.details.api.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface AlbumDetailsComponent : MVIComponent<AlbumDetailsUIState, AlbumDetailsIntent, AlbumDetailsSideEffect>