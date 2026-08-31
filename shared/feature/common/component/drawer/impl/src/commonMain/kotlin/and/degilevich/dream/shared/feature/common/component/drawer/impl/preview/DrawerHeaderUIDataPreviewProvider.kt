package and.degilevich.dream.shared.feature.common.component.drawer.impl.preview

import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerHeaderUIData
import and.degilevich.dream.shared.feature.user.ui.api.preview.UserAvatarUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class DrawerHeaderUIDataPreviewProvider : LabeledPreviewParameterProvider<DrawerHeaderUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): DrawerHeaderUIData {
        return DrawerHeaderUIData(
            avatar = UserAvatarUIDataPreviewProvider().provideDefault(),
            name = "User"
        )
    }
}
