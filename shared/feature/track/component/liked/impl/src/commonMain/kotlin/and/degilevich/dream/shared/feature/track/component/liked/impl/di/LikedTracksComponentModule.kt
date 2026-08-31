package and.degilevich.dream.shared.feature.track.component.liked.impl.di

import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.LikedTracksComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun likedTracksComponentModule() = module {
    factory<LikedTracksComponent> { (componentContext: ComponentContext) ->
        LikedTracksComponentImpl(componentContext = componentContext)
    }
}
