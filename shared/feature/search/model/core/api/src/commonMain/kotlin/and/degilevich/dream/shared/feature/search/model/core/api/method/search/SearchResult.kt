package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

data class SearchResult(
    val tracks: List<TrackData>,
    val artists: List<ArtistData>,
    val albums: List<AlbumSimplifiedData>,
)