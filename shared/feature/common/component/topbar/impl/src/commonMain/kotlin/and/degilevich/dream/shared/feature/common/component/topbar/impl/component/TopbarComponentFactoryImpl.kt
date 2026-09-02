package and.degilevich.dream.shared.feature.common.component.topbar.impl.component

import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponent
import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class TopbarComponentFactoryImpl : TopbarComponentFactory {

    override fun create(componentContext: ComponentContext): TopbarComponent = TopbarComponentImpl(
        componentContext = componentContext
    )
}
