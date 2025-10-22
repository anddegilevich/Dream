package and.degilevich.dream.shared.resource.api

import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource

interface ResourceManager {
    fun getString(resource: StringResource): String
    fun getString(
        resource: StringResource,
        vararg args: Any
    ): String

    fun getString(
        resource: PluralsResource,
        number: Int
    ): String

    fun getColor(resource: ColorResource): Color
}