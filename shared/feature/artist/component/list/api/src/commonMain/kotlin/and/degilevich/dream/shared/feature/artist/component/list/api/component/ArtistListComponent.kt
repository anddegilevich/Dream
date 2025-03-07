package and.degilevich.dream.shared.feature.artist.component.list.api.component

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface ArtistListComponent : MVIComponent<ArtistListUIState, ArtistListIntent, ArtistListSideEffect>