package com.happiestminds.kotlinprogramming

fun main() {

    //1. arrayOf()

    var numbers = arrayOf(10,20,30,40,50)

    println(numbers.contentToString())
    numbers[0] = 100
    println(numbers.contentToString())
    println("Size : ${numbers.size}")
    println("First element: ${numbers.first()}")
    println("200 is part of array? ${numbers.contains(200)}")
    println("index of element 100: ${numbers.indexOf(100)}")
   // println(numbers[10])

    //2. using constructor of Array class

    val primeNumbers = Array(5){0}
    println("Original array: ${primeNumbers.contentToString()}")
    primeNumbers[0] = 2
    primeNumbers[1] = 3

    println("prime array: ${primeNumbers.contentToString()}")

    //3. specialized type array

    val evenNumbers = IntArray(4)
    println("Original: ${evenNumbers.contentToString()}")
    evenNumbers[0] = 2
    evenNumbers[1] = 4
    evenNumbers[2] = 6



    val newArray = primeNumbers + numbers


    println("mixed: ${newArray.contentToString()}")

    val rArray = newArray.reversedArray()
    println("REversed: ${rArray.contentToString()}")
}