package and.degilevich.dream.shared.resource.impl

import and.degilevich.dream.shared.resource.api.ResourceManager
import android.content.Context
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format

internal actual class ResourceManagerImpl(
    private val context: Context
) : ResourceManager {
    override fun getString(resource: StringResource): String {
        return resource.desc().toString(context = context)
    }

    override fun getString(
        resource: StringResource,
        vararg args: Any
    ): String {
        return if (args.isEmpty()) {
            getString(resource)
        } else {
            resource.format(*args).toString(context = context)
        }
    }

    override fun getString(
        resource: PluralsResource,
        number: Int
    ): String {
        return resource.format(number, number).toString(context = context)
    }
}