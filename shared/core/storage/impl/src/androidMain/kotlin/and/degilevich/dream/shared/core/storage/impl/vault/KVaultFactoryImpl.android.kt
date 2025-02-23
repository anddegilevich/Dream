package and.degilevich.dream.shared.core.storage.impl.vault

import android.content.Context
import com.liftric.kvault.KVault

internal actual class KVaultFactoryImpl(
    private val context: Context
) : KVaultFactory {

    override fun create(): KVault {
        return KVault(
            context = context,
            fileName = STORAGE_NAME
        )
    }

    private companion object {
        const val STORAGE_NAME = "dream_storage"
    }
}