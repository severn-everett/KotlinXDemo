package com.severett.lincheck

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test
import java.util.concurrent.*

@Param(name = "key", gen = AnEnumGen::class, conf = "")
class ConcurrentMapTest {
    private val map = ConcurrentHashMap<AnEnum, List<Int>>()

    @Operation
    fun add(@Param(name = "key") key: AnEnum, value: Int) {
        val list = map[key]
        if (list == null) {
            map[key] = listOf(value)
        } else {
            map[key] = list + value
        }
        // map.compute(key) { _, l -> if (l != null) l + value else listOf(value) }
    }

    @Operation
    fun get(@Param(name = "key") key: AnEnum) = map[key] ?: emptyList()

    @Test
    fun stressTest() = StressOptions().check(this::class.java)
    @Test
    fun modelTest() = ModelCheckingOptions().check(this::class)
}
