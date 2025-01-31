//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.resource.impl

import and.degilevich.dream.shared.core.resource.api.ResourceManager
import android.content.Context
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.format

internal actual class ResourceManagerImpl(
    private val context: Context
) : ResourceManager {
    override fun getString(resource: StringResource): String {
        return StringDesc.Resource(resource).toString(context = context)
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