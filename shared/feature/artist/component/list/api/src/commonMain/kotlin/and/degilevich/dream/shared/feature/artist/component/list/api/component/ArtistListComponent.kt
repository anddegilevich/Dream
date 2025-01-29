package and.degilevich.dream.shared.feature.artist.component.list.api.component

import and.degilevich.dream.shared.common.component.view.ViewComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState

interface ArtistListComponent : ViewComponent<ArtistListUIState, ArtistListIntent, ArtistListSideEffect>