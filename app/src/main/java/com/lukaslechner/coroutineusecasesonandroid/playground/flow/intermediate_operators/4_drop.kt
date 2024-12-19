package com.lukaslechner.coroutineusecasesonandroid.playground.flow.intermediate_operators

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile


suspend fun main() {
    flowOf(1, 2, 3, 4, 5)
        .dropWhile { it < 3 }
        .collect { collectValue ->
            println(collectValue)
        }
}