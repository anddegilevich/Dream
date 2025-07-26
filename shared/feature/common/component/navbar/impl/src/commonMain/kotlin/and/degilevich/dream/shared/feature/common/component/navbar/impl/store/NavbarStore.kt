package and.degilevich.dream.shared.feature.common.component.navbar.impl.store

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import com.arkivanov.mvikotlin.core.store.Store

internal interface NavbarStore : Store<NavbarIntent, NavbarState, NavbarSideEffect>