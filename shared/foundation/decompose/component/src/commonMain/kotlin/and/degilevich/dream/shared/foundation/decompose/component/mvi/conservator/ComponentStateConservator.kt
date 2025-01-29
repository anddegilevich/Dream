package and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator

import kotlinx.serialization.KSerializer

interface ComponentStateConservator<State : Any> {
    val key: String
    val initialState: State
    val serializer: KSerializer<State>
}