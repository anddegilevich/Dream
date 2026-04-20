package and.degilevich.dream.shared.resource.api.pallet

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
enum class PalletColor(
    override val id: Identifier
) : Identified {
    PURPLE(id = identifier("purple")),
    ORANGE(id = identifier("orange")),
    BLUE(id = identifier("blue")),
    UNDEFINED(id = identifier("undefined"))
}