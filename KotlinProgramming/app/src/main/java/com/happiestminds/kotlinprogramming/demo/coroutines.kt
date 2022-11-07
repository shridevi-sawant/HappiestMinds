package com.happiestminds.kotlinprogramming.demo

import kotlinx.coroutines.*

// suspend function - executed from another suspend function or from coroutine
private suspend fun sum(a: Int, b: Int) : Int{
    println("Sum executed by: ${Thread.currentThread().name}")
    delay(2000)
    val result = a + b

    return result
}

private suspend fun diff(a:Int, b:Int) : Int {
    delay(3000)
    val result = a - b
    println("Diff executed by: ${Thread.currentThread().name}")
    return result
}


fun main() {

    // launch, async, runBlocking -> coroutine builder functions
    // runBlocking - to create high level coroutine

    // launch -> fire and forget
    runBlocking {
        val j1 = launch(Dispatchers.IO) {
            val res = sum(10, 20)
            println("result of sum: $res: ${Thread.currentThread().name}")
        }

        // async - result of coroutine is to be captured
        val defferedRandom = async {
            getRandom()
        }

        val num1 = defferedRandom.await()
        println("num1 : $num1")

        val j2 = launch {
            val res = diff(num1, 20)
            println("diff between $num1 and 20: $res")
        }

        //j2.cancel()
        for (i in 1..1_100_000){
            launch {
                delay(1000)
                print("*")
            }
        }
    }



    println("----DONE---")
}

suspend fun getRandom(): Int {
    println("Getting random number")
    delay(2000)
    return (Math.random() * 100).toInt()
}