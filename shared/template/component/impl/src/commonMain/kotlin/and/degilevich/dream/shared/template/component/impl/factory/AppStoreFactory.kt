package and.degilevich.dream.shared.template.component.impl.factory

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory

internal class AppStoreFactory : StoreFactory by LoggingStoreFactory(
    delegate = DefaultStoreFactory(),
    logger = StoreFactoryLogger()
)