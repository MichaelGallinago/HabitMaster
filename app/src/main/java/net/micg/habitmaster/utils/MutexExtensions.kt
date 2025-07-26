package net.micg.habitmaster.utils

import kotlinx.coroutines.sync.Mutex
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object MutexExtensions {
    @OptIn(ExperimentalContracts::class)
    inline fun Mutex.tryWithLock(owner: Any? = null, action: () -> Unit) {
        contract {
            callsInPlace(action, InvocationKind.AT_MOST_ONCE)
        }
        if (!tryLock(owner)) return

        return try {
            action()
        } finally {
            unlock(owner)
        }
    }
}
