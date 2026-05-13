package and.degilevich.dream.shared.resource.api.pallet

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
enum class PalletColor(
    override val id: AnyIdentifier
) : Identified {
    PURPLE(id = identifier("purple")),
    ORANGE(id = identifier("orange")),
    BLUE(id = identifier("blue")),
    UNDEFINED(id = identifier("undefined"))
}