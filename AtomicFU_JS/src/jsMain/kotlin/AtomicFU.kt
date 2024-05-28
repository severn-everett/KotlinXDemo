import kotlinx.atomicfu.atomic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val LIMIT = 10_000

class Foo {
    private val safeCounter = atomic(0)
    private var unsafeCounter = 0

    suspend fun runRace() {
        (0 until LIMIT).map {
            CoroutineScope(Dispatchers.Default).launch {
                safeCounter += 1
                unsafeCounter += 1
            }
        }.forEach { it.join() }
        println("Safe counter: ${safeCounter.value}")
        println("Unsafe counter: $unsafeCounter")
    }
}

suspend fun main() {
    val foo = Foo()
    foo.runRace()
}
