package and.degilevich.dream.shared.feature.album.ui.impl.mapper

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.resource.test.FakeResourceManager
import dev.icerock.moko.resources.StringResource
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumTypeToUITextMapperImplTest {

    @Test
    fun `map - ALBUM - resolves album_type_album resource`() {
        var lastStringResource: StringResource? = null
        val mapper = createMapper(onGetString = { lastStringResource = it })
        mapper.map(AlbumType.ALBUM) shouldBe "mapped text"
        lastStringResource shouldBe Res.strings.album_type_album
    }

    @Test
    fun `map - SINGLE - resolves album_type_single resource`() {
        var lastStringResource: StringResource? = null
        val mapper = createMapper(onGetString = { lastStringResource = it })
        mapper.map(AlbumType.SINGLE) shouldBe "mapped text"
        lastStringResource shouldBe Res.strings.album_type_single
    }

    @Test
    fun `map - COMPILATION - resolves album_type_compilation resource`() {
        var lastStringResource: StringResource? = null
        val mapper = createMapper(onGetString = { lastStringResource = it })
        mapper.map(AlbumType.COMPILATION) shouldBe "mapped text"
        lastStringResource shouldBe Res.strings.album_type_compilation
    }

    @Test
    fun `map - UNKNOWN - falls back to the generic error resource`() {
        var lastStringResource: StringResource? = null
        val mapper = createMapper(onGetString = { lastStringResource = it })
        mapper.map(AlbumType.UNKNOWN) shouldBe "mapped text"
        lastStringResource shouldBe Res.strings.error
    }

    private fun createMapper(onGetString: (StringResource) -> Unit) = AlbumTypeToUITextMapperImpl(
        resourceManager = FakeResourceManager(
            onGetString = {
                onGetString(it)
                "mapped text"
            }
        )
    )
}
