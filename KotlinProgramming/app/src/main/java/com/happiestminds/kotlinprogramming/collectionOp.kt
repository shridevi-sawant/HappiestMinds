package com.happiestminds.kotlinprogramming

fun main() {
    val numbers = listOf(1,2,3,10,5,4,9,8)

    // even numbers - filter
    // size of collection : equal to or smaller than original
    val evenList = numbers.filter {
        it % 2 == 0
    }

    println("All numbers: $numbers")
    println("Even List: $evenList")

    // square of all numbers - map
    // size of collection - same as original
    val squareList = numbers.map {
        it * it
    }

    println("SQuare : $squareList")

    // square of even numbers - filter, map

    val squareOfEvens = numbers.filter { it % 2 == 0 }.map { it * it}

    println("SQuare of evens: $squareOfEvens")

    // zip
    val numberList = listOf(1, 2, 3, 4, 5)
    val nameList = listOf("one", "two", "three", "four", "five")

    val numberNames = numberList.zip(nameList)
    println("NumberNames: $numberNames")

    // grouping
    val data = listOf(1,2,3,4,5,6,7,8,9,10)

    val groupMap = data.groupBy {
        if (it % 2 == 0) "even" else "odd"
    }

    println(groupMap)

    // reduce -
    // cumulative product

    val cumProduct = data.reduce { product, element ->
        product * element
    }

    println("Cum product: $cumProduct")

    println("Max: ${data.max()}")
    println("Smallest: ${data.min()}")
    println("Sum: ${data.sum()}")
    println("Avg: ${data.average()}")

}