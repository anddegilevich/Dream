package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponentFactory
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

internal class AlbumDetailsComponentFactoryImpl : AlbumDetailsComponentFactory {

    override fun create(
        componentContext: ComponentContext,
        navArgs: AlbumDetailsNavArgs
    ): AlbumDetailsComponent = AlbumDetailsComponentImpl(
        componentContext = componentContext,
        navArgs = navArgs
    )
}
