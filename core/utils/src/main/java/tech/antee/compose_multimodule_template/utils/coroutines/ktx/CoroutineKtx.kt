package tech.antee.compose_multimodule_template.utils.coroutines.ktx

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun launchSecurely(
    scope: CoroutineScope,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    onLoading: ((Boolean) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null,
    onFinally: (() -> Unit)? = null,
    block: suspend CoroutineScope.() -> Unit
): Job = scope.launch(context, start) {
    try {
        onLoading?.invoke(true)
        block()
    } catch (e: Throwable) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        onError?.invoke(e)
    } finally {
        onLoading?.invoke(false)
        onFinally?.invoke()
    }
}