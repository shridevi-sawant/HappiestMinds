package com.happiestminds.kotlinprogramming

fun main() {

    val numbers = 1..10
    println(numbers.toList())
    val numRange = 10.downTo(1)
    println(numRange.toList())
    println("odd numbers: ${numbers.step(2).toList()}")

    val evenNum = (2..20).step(2)
    var x = 5
    val isEven = x in evenNum
    println(isEven)

    val allChars = 'A'..'Z'
    println(allChars.toList())
}