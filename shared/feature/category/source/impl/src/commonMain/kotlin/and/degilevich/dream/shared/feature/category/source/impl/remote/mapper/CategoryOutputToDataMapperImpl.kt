package and.degilevich.dream.shared.feature.category.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.category.CategoryOutput
import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.CategoryOutputToDataMapper
import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class CategoryOutputToDataMapperImpl(
    private val imageOutputToDataMapper: ImageObjectOutputToDataMapper
) : CategoryOutputToDataMapper {

    override fun map(item: CategoryOutput): CategoryData = with(item) {
        CategoryData(
            id = id.orEmpty(),
            name = name.orEmpty(),
            icons = icons?.mapWith(imageOutputToDataMapper).orEmpty()
        )
    }
}