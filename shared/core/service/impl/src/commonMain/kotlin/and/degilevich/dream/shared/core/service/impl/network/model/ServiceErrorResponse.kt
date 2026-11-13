package and.degilevich.dream.shared.core.service.impl.network.model

import and.degilevich.dream.shared.core.service.api.generated.model.ErrorObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ServiceErrorResponse(
    @SerialName("error")
    val error: ErrorObject
)
