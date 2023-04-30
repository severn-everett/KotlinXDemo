package com.severett.serialization

import com.severett.serialization.model.Foo
import com.severett.serialization.model.ThirdPartyFoo
import com.severett.serialization.serde.ThirdPartyFooSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val fizz = "FUZZ"
private val bazz = listOf("BIZZ", "BUZZ")
private val count = 20u

fun main() {
    serdeFoo()
    serdeThirdPartyFoo()
}

private fun serdeFoo() {
    val jsonStr = Json.encodeToString(Foo(fizz, bazz, count))
    println("ENCODED: $jsonStr")
    val newFoo = Json.decodeFromString<Foo>(jsonStr)
    println("DECODED: $newFoo")
}

private fun serdeThirdPartyFoo() {
    val jsonStr = Json.encodeToString(ThirdPartyFooSerializer, ThirdPartyFoo(fizz, bazz, count))
    println("3RD-PARTY ENCODED: $jsonStr")
    val newThirdPartyFoo = Json.decodeFromString(ThirdPartyFooSerializer, jsonStr)
    println("3RD-PARTY DECODED: $newThirdPartyFoo")
}
