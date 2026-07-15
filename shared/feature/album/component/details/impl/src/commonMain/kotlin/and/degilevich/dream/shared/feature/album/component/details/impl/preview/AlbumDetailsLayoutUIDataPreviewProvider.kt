package and.degilevich.dream.shared.feature.album.component.details.impl.preview

import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class AlbumDetailsLayoutUIDataPreviewProvider : LabeledPreviewParameterProvider<AlbumDetailsLayoutUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): AlbumDetailsLayoutUIData {
        return AlbumDetailsLayoutUIData.empty().copy(
            name = "Album",
            type = "Album",
            year = "2000",
        )
    }
}