package com.happiestminds.kotlinprogramming

// ()->Unit
fun main() {

    var x: (Int,Int) -> Int

    x = ::doAdd
    x(10, 20)

    x = ::doSubtract
    x(10, 20)

    doCalculate(100, 400, ::doAdd)
    doCalculate(300, 100, ::doSubtract)
    // lambda expression
    val doMultiply = { arg1: Int, arg2: Int ->
        val res = arg1 * arg2
        println("product of $arg1 and $arg2 : $res")
        res
    }

    doCalculate(10, 20, doMultiply)
    // trailing lambda
    doCalculate(100, 10) { arg1, arg2 ->
        val res = arg1 / arg2
        println("Division: $res")
        res
    }
}

// type -
// (Int,Int) -> Int
fun doAdd(a: Int, b:Int) : Int {
    val res = a + b
    println("Add result: $res")
    return res
}

fun doSubtract(a: Int, b: Int) : Int {
    val res = a - b
    println("Subtract result: $res")
    return res
}

// higher order function - input parameter or return value is function

fun doCalculate(a: Int, b: Int, operation: (Int, Int) -> Int){
    operation(a,b)
}