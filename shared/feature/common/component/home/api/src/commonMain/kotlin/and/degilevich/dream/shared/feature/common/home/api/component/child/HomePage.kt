package and.degilevich.dream.shared.feature.common.home.api.component.child

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface HomePage {

    @Stable
    class Dashboard(
        component: DashboardComponent
    ) : HomePage, DashboardComponent by component

    @Stable
    class Search(
        component: SearchComponent
    ) : HomePage, SearchComponent by component
}