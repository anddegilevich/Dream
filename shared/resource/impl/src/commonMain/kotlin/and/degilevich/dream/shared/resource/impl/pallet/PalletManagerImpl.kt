package and.degilevich.dream.shared.resource.impl.pallet

import and.degilevich.dream.Res
import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.resource.api.pallet.PalletColor
import and.degilevich.dream.shared.resource.api.pallet.PalletManager
import androidx.compose.ui.graphics.Color

internal class PalletManagerImpl(
    private val resourceManager: ResourceManager
) : PalletManager {

    override fun getColor(color: PalletColor): Color {
        val colorRes = when (color) {
            PalletColor.PURPLE -> Res.colors.pallet_purple
            PalletColor.ORANGE -> Res.colors.pallet_orange
            PalletColor.BLUE -> Res.colors.pallet_blue
            PalletColor.UNDEFINED -> Res.colors.pallet_blue
        }
        return resourceManager.getColor(resource = colorRes)
    }
}