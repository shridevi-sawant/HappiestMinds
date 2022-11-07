package com.happiestminds.kotlinprogramming

import com.happiestminds.kotlinprogramming.demo.Animal
import com.happiestminds.kotlinprogramming.demo.add
import com.happiestminds.kotlinprogramming.demo.factorialOfNum as fact1
import com.happiestminds.kotlinprogramming.xyz.factorialOfNum as fact2
import java.math.BigInteger


// private- within file
// internal - within module(package)
// public - everywhere

fun main() {
    val dog = Animal()
    add(10, 20)

    fact1(10)
    fact2(20)

}