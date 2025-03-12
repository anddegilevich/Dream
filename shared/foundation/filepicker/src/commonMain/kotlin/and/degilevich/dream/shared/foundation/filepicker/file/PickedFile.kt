package and.degilevich.dream.shared.foundation.filepicker.file

import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState

interface PickedFile : EmptyState {
    val path: String
}