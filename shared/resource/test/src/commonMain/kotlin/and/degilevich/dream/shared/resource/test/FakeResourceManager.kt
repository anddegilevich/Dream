package and.degilevich.dream.shared.resource.test

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.resource.api.ResourceManager
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource

class FakeResourceManager(
    private val onGetString: (StringResource) -> String = { fakeImplementationError() },
    private val onGetStringWithArgs: (StringResource, List<Any>) -> String = { _, _ -> fakeImplementationError() },
    private val onGetPluralString: (PluralsResource, Int) -> String = { _, _ -> fakeImplementationError() },
    private val onGetColor: (ColorResource) -> Color = { fakeImplementationError() }
) : ResourceManager {

    override fun getString(resource: StringResource): String {
        return onGetString(resource)
    }

    override fun getString(
        resource: StringResource,
        vararg args: Any
    ): String {
        return onGetStringWithArgs(resource, args.asList())
    }

    override fun getString(
        resource: PluralsResource,
        number: Int
    ): String {
        return onGetPluralString(resource, number)
    }

    override fun getColor(resource: ColorResource): Color {
        return onGetColor(resource)
    }
}