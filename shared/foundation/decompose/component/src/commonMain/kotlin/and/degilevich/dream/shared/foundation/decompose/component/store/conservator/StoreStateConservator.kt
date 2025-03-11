package and.degilevich.dream.shared.foundation.decompose.component.store.conservator

import kotlinx.serialization.KSerializer

interface StoreStateConservator<State : Any> {
    val key: String
    val initialState: State
    val serializer: KSerializer<State>
}