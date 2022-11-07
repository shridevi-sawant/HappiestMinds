package com.happiestminds.kotlinprogramming


fun main() {

    // val - immutable- cannot modify
    val pi : Float = 3.142f

    // var - mutable - can be modified
    var name = "HappiestMinds"
    name = "HappiestMinds Bangalore"

    println("Hi")
    println(pi)
    println(name)

    var x = 10
    var y: Short = 3

    var result : Float = x / y.toFloat()

    println(result)

    val remainder = x % y

    // String interpolation
    println("Remainder of division of $x / $y = ${x % y}")

    x += 10 // x = x + 10

    println("Updated x : $x")
    x++
    --x

    println("updated x : $x")

    x = 1_000

    // boolean
    var isValid = true

    isValid = x > 2000
    println("is Valid? $isValid")
    // char

    var delimiter = 'A'
    println("Delimiter is $delimiter")
    println("ASCII num for $delimiter: ${delimiter.code}")

    val num = 66
    println(num.toChar())

}