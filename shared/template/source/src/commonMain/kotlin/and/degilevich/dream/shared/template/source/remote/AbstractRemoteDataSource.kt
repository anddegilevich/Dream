package and.degilevich.dream.shared.template.source.remote

import and.degilevich.dream.shared.core.service.api.Service
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class AbstractRemoteDataSource : RemoteDataSource, KoinComponent {
    protected val service: Service by inject()
}