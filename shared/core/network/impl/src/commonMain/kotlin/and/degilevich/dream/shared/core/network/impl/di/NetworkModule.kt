package and.degilevich.dream.shared.core.network.impl.di

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.RemoteClientImpl
import and.degilevich.dream.shared.core.network.impl.configurator.ContentNegotiationConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.ContentNegotiationConfiguratorImpl
import and.degilevich.dream.shared.core.network.impl.configurator.LoggingConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.LoggingConfiguratorImpl
import and.degilevich.dream.shared.core.network.impl.configurator.NetworkErrorConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.NetworkErrorConfiguratorImpl
import and.degilevich.dream.shared.core.network.impl.configurator.TimeoutConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.TimeoutConfiguratorImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun networkModule() = module {
    includes(networkPlatformModule())
    singleOf(::LoggingConfiguratorImpl) bind LoggingConfigurator::class
    singleOf(::ContentNegotiationConfiguratorImpl) bind ContentNegotiationConfigurator::class
    singleOf(::TimeoutConfiguratorImpl) bind TimeoutConfigurator::class
    singleOf(::NetworkErrorConfiguratorImpl) bind NetworkErrorConfigurator::class
    singleOf(::RemoteClientImpl) bind RemoteClient::class
}