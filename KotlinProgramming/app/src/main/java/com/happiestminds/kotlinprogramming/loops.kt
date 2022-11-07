package com.happiestminds.kotlinprogramming

fun main() {

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)

    // for loop
    for ( num in numbers) {
        println("Square of $num : ${num*num}")
    }

    for (idx in numbers.indices) {
        println("element at index $idx : ${numbers[idx]}")
    }

    for ((idx, item) in numbers.withIndex()){
        println("element at index $idx : $item")
    }

    // while - condition based
    var num = 0
    while (num < 5)
        num++

    println("Num: $num")

    do{
        num--
    }while (num > 0)

    println("decremented.. $num")

    // break, continue
    val address = "Electronic City, Bangalore"
    for (ch in address) {
        if (ch == ',') {
            //break
            continue
        }
        print(ch)
    }

    println()
    println("DONE")

}