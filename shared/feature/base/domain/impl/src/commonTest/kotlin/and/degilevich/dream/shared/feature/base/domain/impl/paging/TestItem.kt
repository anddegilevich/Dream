package and.degilevich.dream.shared.feature.base.domain.impl.paging

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
internal data class TestItem(
    private val value: String
) : Identified {

    override val id: Identifier = AnyIdentifier(value = value)
}
