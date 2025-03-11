package and.degilevich.dream.shared.resource.impl

import and.degilevich.dream.shared.resource.api.ResourceManager
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.format

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
}