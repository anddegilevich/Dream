package and.degilevich.dream.shared.resource.api.pallet

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
enum class PalletColor(
    override val id: Identifier
) : Identified {
    PURPLE(id = Identifier("purple")),
    ORANGE(id = Identifier("orange")),
    BLUE(id = Identifier("blue")),
    UNDEFINED(id = Identifier("undefined"))
}