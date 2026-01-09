package and.degilevich.dream.shared.resource.api.pallet

import androidx.compose.ui.graphics.Color

interface PalletManager {
    fun getColor(color: PalletColor): Color
}