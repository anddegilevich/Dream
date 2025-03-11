package and.degilevich.dream.shared.resource.impl.di

import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.resource.impl.ResourceManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun resourcePlatformModule() = module {
    singleOf(::ResourceManagerImpl) bind ResourceManager::class
}