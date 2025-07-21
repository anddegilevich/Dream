package and.degilevich.dream.shared.feature.album.design.impl.mapper

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumTypeToUITextMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.resource.api.ResourceManager

internal class AlbumTypeToUITextMapperImpl(
    private val resourceManager: ResourceManager
) : AlbumTypeToUITextMapper {
    override fun map(item: AlbumType): String {
        val resource = when (item) {
            AlbumType.ALBUM -> Res.strings.album_type_album
            AlbumType.SINGLE -> Res.strings.album_type_single
            AlbumType.COMPILATION -> Res.strings.album_type_compilation
            AlbumType.UNKNOWN -> Res.strings.error
        }
        return resourceManager.getString(resource)
    }
}