package and.degilevich.dream.convention.common

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.TestExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

internal typealias AndroidExtensions = CommonExtension<
        out BuildFeatures,
        out BuildType,
        out DefaultConfig,
        out ProductFlavor,
        out AndroidResources,
        out Installation>

internal fun Project.androidExtension(): AndroidExtensions {
    return extensions.findByType(BaseAppModuleExtension::class)
        ?: extensions.findByType(LibraryExtension::class)
        ?: extensions.findByType(TestExtension::class)
        ?: error(
            buildString {
                append("\"Project.and.degilevich.dream.convention.getAndroidExtension\" ")
                append("value may be called only from android application or android library gradle script")
            }
        )
}