package com.happiestminds.kotlinprogramming.demo

fun main() {
    val cust1 = Customer()
    cust1.name = "John" // getter/setter of java - properties in kotlin

    println(cust1.name)
    cust1.`is`()
}

fun multiply(a: Int, b: Int) : Int {
    return a * b
}