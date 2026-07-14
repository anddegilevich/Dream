package and.degilevich.dream.shared.feature.album.component.details.impl.di

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.album.component.details.impl.component.AlbumDetailsComponentImpl
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun albumDetailsComponentModule() = module {
    factory<AlbumDetailsComponent> { (componentContext: ComponentContext, navArgs: AlbumDetailsNavArgs) ->
        AlbumDetailsComponentImpl(componentContext = componentContext, navArgs = navArgs)
    }
}
