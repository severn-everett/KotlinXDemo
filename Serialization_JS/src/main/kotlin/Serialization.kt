import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Foo(val fizz: String, val bazz: List<String>, val count: UInt)

fun main() {
    val jsonStr = Json.encodeToString(Foo("FUZZ", listOf("BIZZ", "BUZZ"), 20u))
    println("ENCODED: $jsonStr")
    val newFoo = Json.decodeFromString<Foo>(jsonStr)
    println("DECODED: $newFoo")
}
