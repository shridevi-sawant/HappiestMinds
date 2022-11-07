package com.happiestminds.kotlinprogramming.demo

import kotlin.concurrent.thread

private fun sum(a: Int, b: Int){
    Thread.sleep(2000)
    println("Sum executed by: ${Thread.currentThread().name}")
    val result = a + b
    println("Sum of $a and $b : $result")
}

private fun diff(a:Int, b: Int){
    Thread.sleep(2000)
    println("diff executed by ${Thread.currentThread().name}")
    val result = a - b
    println("Diff of $a and $b : $result")
}


fun main() {

    println("Printing from main thread: ${Thread.currentThread().name}")

    val t1 = thread(start = false, name = "additionThread") {
        // long-running, parallel execution, non-blocking execution
        sum(10, 20)
    }

    val t2 = thread(name = "subtractionThread") {
        diff(10, 20)
    }

    // once t2 done, start t1

    t2.join() // waits until thread finishes
    println("t2 is done")
    t1.start()

    t1.join()// wait for t1 to finish
    println("t1 is done")
    println("--Done--")

    for (i in 1..1_00_000){
        thread {
            Thread.sleep(1000)
            print("*")
        }
    }
}