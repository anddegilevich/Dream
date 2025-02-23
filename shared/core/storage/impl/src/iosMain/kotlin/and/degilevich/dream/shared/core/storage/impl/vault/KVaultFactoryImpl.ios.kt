package and.degilevich.dream.shared.core.storage.impl.vault

import com.liftric.kvault.KVault

internal actual class KVaultFactoryImpl : KVaultFactory {
    override fun create(): KVault {
        return KVault()
    }
}