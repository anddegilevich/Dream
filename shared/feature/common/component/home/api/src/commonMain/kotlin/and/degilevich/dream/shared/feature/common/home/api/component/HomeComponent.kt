package and.degilevich.dream.shared.feature.common.home.api.component

import and.degilevich.dream.shared.feature.common.home.api.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.api.component.model.HomePageConfig
import androidx.compose.runtime.Stable
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value

@Stable
interface HomeComponent {
    val navbar: HomeNavbar
    val pages: Value<ChildPages<HomePageConfig, HomePage>>
}