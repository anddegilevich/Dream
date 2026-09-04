package and.degilevich.dream.shared.feature.album.component.details.api.component

import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

interface AlbumDetailsComponentFactory {

    fun create(
        componentContext: ComponentContext,
        navArgs: AlbumDetailsNavArgs
    ): AlbumDetailsComponent
}
