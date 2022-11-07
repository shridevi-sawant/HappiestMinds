package com.happiestminds.kotlinprogramming

import kotlin.math.sqrt

fun main() {
    var num = -5

    while (num != 0){
//        val operation = makeZero(num)
//        num = operation()
        num = makeZero(num)()
        println("Updated num: $num")
    }

    // Type
    // (String) -> Int?
    var strToDigit = { str: String ->
        println("Input String: $str")
        str.toIntOrNull()
    }

    val result = strToDigit("12") ?: 0
    println("Converted: $result")

    strToDigit = {
        println("Input: $it")
        it.toIntOrNull()
    }

    val converted = strToDigit("8773") ?: 0
    println("Converted: $converted")

    var mathOperation : (Int) -> Int
    mathOperation = {
        println("Squaring $it")
        it * it
    }

    println("Square of 26: ${mathOperation(26)}")
    mathOperation = {
        sqrt(it.toDouble()).toInt()
    }

    println("SQuare root of 676: ${mathOperation(676)}")
    println("Kotlin".removeFirstAndLast())

    val data = arrayOf<Any>(1,23,4)
    data.printElements()

    val names = arrayOf<Any>("john", "merry")
    names.printElements()
}

// extension to Array to print elements
fun Array<Any>.printElements(){
    print("[")
    for (e in this) {
        print("$e,")
    }
    println("]")
}

// extension to String
fun String.removeFirstAndLast() : String {
   return this.substring(1, this.length - 1)
}

// higher order function
// nested/local function
fun makeZero(number: Int) : () -> Int {

    fun increment() = number + 1

    fun decrement() = number - 1

    return if (number > 0) ::decrement else ::increment
}