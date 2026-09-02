package and.degilevich.dream.shared.feature.search.ui.api.mapper

import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchItemDataToSearchCardUIDataMapper : Mapper<SearchItemData, SearchCardUIData>
