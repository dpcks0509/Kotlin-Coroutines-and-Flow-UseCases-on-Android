package com.lukaslechner.coroutineusecasesonandroid.playground.flow.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest

suspend fun main() = coroutineScope {
    val flow = flow {
        repeat(5) {
            val pancakeIndex = it + 1
            println("Emitter: Start Cooking Pancake $pancakeIndex")
            delay(100)
            println("Emitter: Pancake $pancakeIndex ready!")
            emit(it)
        }
    }.mapLatest {
        println("Add topping onto the pancake $it")
        delay(200)
        it
    }

    flow.collect {
        println("Collector: Start eating Pancake $it")
        delay(300)
        println("Collector: Finished eating Pancake $it")
    }
}