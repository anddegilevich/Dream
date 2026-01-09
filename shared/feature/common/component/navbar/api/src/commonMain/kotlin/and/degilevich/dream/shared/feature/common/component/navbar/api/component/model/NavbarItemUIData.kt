package and.degilevich.dream.shared.feature.common.component.navbar.api.component.model

import and.degilevich.dream.Res
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable
import dev.icerock.moko.resources.ImageResource

@Immutable
data class NavbarItemUIData(
    override val id: Identifier,
    val icon: ImageResource,
    val text: String,
    val isSelected: Boolean
) : Identified {
    companion object : EmptyFactory<NavbarItemUIData> {
        override fun empty(): NavbarItemUIData {
            return NavbarItemUIData(
                id = Identifier.empty(),
                icon = Res.images.ic_home,
                text = "",
                isSelected = false
            )
        }
    }
}