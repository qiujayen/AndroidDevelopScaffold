package ads.kotlin.stdlib

/**
 * @author QiuJie
 */
inline fun <C : CharSequence> C.ifEmpty(block: () -> Unit): C {
    if (this.isEmpty()) {
        block()
    }
    return this
}

inline fun <C : CharSequence> C.ifNotEmpty(block: () -> Unit): C {
    if (this.isNotEmpty()) {
        block()
    }
    return this
}

inline fun <C : CharSequence> C?.ifNotNullOrEmpty(block: () -> Unit): C? {
    if (!this.isNullOrEmpty()) {
        block()
    }
    return this
}

inline fun <C : CharSequence> C?.ifNullOrEmpty(block: () -> Unit): C? {
    if (this.isNullOrEmpty()) {
        block()
    }
    return this
}

inline fun <C : CharSequence> C?.ifNullOrBlank(block: () -> Unit): C? {
    if (this.isNullOrBlank()) {
        block()
    }
    return this
}

inline fun <T, C : Collection<T>> C?.ifNullOrEmpty(block: () -> Unit): C? {
    if (this.isNullOrEmpty()) {
        block()
    }
    return this
}

inline fun <T, C : Collection<T>> C?.ifNotNullOrEmpty(block: () -> Unit): C? {
    if (!this.isNullOrEmpty()) {
        block()
    }
    return this
}