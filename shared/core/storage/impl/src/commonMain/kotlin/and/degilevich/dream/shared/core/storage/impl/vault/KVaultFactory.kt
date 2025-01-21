package and.degilevich.dream.shared.core.storage.impl.vault

import com.liftric.kvault.KVault

internal interface KVaultFactory {
    fun create(): KVault
}