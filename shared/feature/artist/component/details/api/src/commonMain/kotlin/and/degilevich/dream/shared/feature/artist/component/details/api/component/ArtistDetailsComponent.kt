package and.degilevich.dream.shared.feature.artist.component.details.api.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface ArtistDetailsComponent : MVIComponent<ArtistDetailsUIState, ArtistDetailsIntent, ArtistDetailsSideEffect>