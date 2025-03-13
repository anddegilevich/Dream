package and.degilevich.dream.shared.feature.user.component.profile.api.componen.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified

data class ProfilePhotoUIData(
    override val id: String,
    val uri: String
) : Identified
