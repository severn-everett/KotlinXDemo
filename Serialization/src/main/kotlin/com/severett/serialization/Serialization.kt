package com.severett.serialization

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@kotlinx.serialization.Serializable
data class Foo(val fizz: String, val bazz: List<String>)

fun main() {
    val jsonStr = Json.encodeToString(Foo("FUZZ", listOf("BIZZ", "BUZZ")))
    println("ENCODED: $jsonStr")
    val newFoo = Json.decodeFromString<Foo>(jsonStr)
    println("DECODED: $newFoo")
}
