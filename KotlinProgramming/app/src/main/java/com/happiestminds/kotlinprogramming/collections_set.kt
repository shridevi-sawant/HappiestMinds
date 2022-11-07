package com.happiestminds.kotlinprogramming

fun main() {
    val numbers = setOf<Int>(1,2,3,4,5,6,7,8,9,10,10) // immutable

    println("Set: $numbers")
    println("First element: ${numbers.first()}")
    println("LAst element: ${numbers.last()}")

    for (num in numbers){
        println("Square of $num: ${num * num} ")
    }

    numbers.forEach {
        println("Cube of $it : ${it * it * it} ")
    }

    val evenNumbers = mutableSetOf<Int>()
    evenNumbers.add(2)
    evenNumbers.add(8)
    evenNumbers.add(4)
    evenNumbers.add(20)
    evenNumbers.add(0)


    println("Even: $evenNumbers")
    evenNumbers.remove(20)
    println("After removal: $evenNumbers")

    val intersection = numbers.intersect(evenNumbers) // common elements
    println("Intersection: $intersection")

    println("Union: ${numbers.union(evenNumbers)}")
    println("Diff: ${numbers.subtract(evenNumbers)}")

    val randomNums = listOf(100,2,9,6,10, 35, 89,100, 21, 2, 9)
    println("Origianl list : $randomNums")

    val uniqRandomNums = randomNums.toSet()
    println("With uniq values : $uniqRandomNums")
}