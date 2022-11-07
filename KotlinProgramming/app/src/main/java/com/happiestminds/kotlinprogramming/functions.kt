package com.happiestminds.kotlinprogramming

fun main() {

    val sum = add(10, 20)
    val diff = subtract(10, 20)
    println("Diff: $diff")
    greeting("john")
    greeting(null)

    add(10.2, 12.34)

}

// function definition
fun add(a: Int, b: Int): Int {
    // function body
    val result = a + b
    println("Add result: $result")
    return result
}

// single expression syntax

//fun subtract(a: Int, b: Int): Int {
//    return a - b
//}

fun subtract(a:Int, b:Int) = a - b

fun greeting(name: String?){

    println("Hello ${name ?: "guest"}")
}

// function overloading

fun add(a:Double, b: Double): Double{
    val result = a + b
    println("Addition of $a and $b: $result")
    return result
}