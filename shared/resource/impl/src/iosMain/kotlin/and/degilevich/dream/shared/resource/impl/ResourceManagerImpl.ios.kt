package and.degilevich.dream.shared.resource.impl

import and.degilevich.dream.shared.resource.api.ResourceManager
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.format
import dev.icerock.moko.resources.getUIColor
import kotlinx.cinterop.DoubleVarOf
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIColor

internal actual class ResourceManagerImpl : ResourceManager {
    override fun getString(resource: StringResource): String {
        return resource.format().localized()
    }

    override fun getString(
        resource: StringResource,
        vararg args: Any
    ): String {
        return resource.format(args.toList()).localized()
    }

    override fun getString(
        resource: PluralsResource,
        number: Int
    ): String {
        return resource.format(number, number).localized()
    }

    @OptIn(ExperimentalForeignApi::class)
    override fun getColor(resource: ColorResource): Color {
        val uiColor: UIColor = resource.getUIColor()

        return memScoped {
            val red: DoubleVarOf<CGFloat> = alloc()
            val green: DoubleVarOf<CGFloat> = alloc()
            val blue: DoubleVarOf<CGFloat> = alloc()
            val alpha: DoubleVarOf<CGFloat> = alloc()

            uiColor.getRed(
                red = red.ptr,
                green = green.ptr,
                blue = blue.ptr,
                alpha = alpha.ptr
            )

            Color(
                red = red.value.toFloat(),
                green = green.value.toFloat(),
                blue = blue.value.toFloat(),
                alpha = alpha.value.toFloat()
            )
        }
    }
}