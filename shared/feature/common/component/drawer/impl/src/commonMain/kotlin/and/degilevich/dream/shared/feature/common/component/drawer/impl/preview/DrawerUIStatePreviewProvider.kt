package and.degilevich.dream.shared.feature.common.component.drawer.impl.preview

import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class DrawerUIStatePreviewProvider : LabeledPreviewParameterProvider<DrawerUIState>() {

    private val drawerHeaderUIDataPreviewProvider = DrawerHeaderUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Loading" to provideLoading()
    )

    fun provideDefault(): DrawerUIState {
        return DrawerUIState(
            user = Skeleton.Value(drawerHeaderUIDataPreviewProvider.provideDefault())
        )
    }

    fun provideLoading(): DrawerUIState {
        return DrawerUIState(
            user = Skeleton.Loading
        )
    }
}
