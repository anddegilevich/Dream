package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.playlist.component.list.impl.di.playlistListComponentModule
import and.degilevich.dream.shared.feature.playlist.data.impl.di.playlistDataModule
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.di.playlistDataMapperModule
import and.degilevich.dream.shared.feature.playlist.domain.impl.di.playlistDomainModule
import and.degilevich.dream.shared.feature.playlist.ui.impl.di.playlistUIModule
import org.koin.dsl.module

internal fun playlistModule() = module {
    includes(playlistDataMapperModule())
    includes(playlistDataModule())
    includes(playlistDomainModule())
    includes(playlistUIModule())
    includes(playlistListComponentModule())
}
