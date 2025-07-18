package and.degilevich.dream.shared.template.source.impl.remote

import and.degilevich.dream.shared.core.service.api.Service
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseRemoteDataSource : KoinComponent {
    protected val service: Service by inject()
}