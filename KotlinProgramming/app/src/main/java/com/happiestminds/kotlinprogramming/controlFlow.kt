package com.happiestminds.kotlinprogramming

import androidx.core.text.isDigitsOnly

fun main() {

    val number = 11
    var isEven : Boolean

    // if as statement
    if (number % 2 == 0) {
        println("its even")
        isEven = true
    }
    else {
        println("Its odd")
        isEven = false
    }

    println("$number is even? $isEven")

    // if as an expression - else is mandatory

    isEven = if (number % 2 == 0) true else false // no ternary operator

    println("isEven = $isEven")

    val num1 = 192
    val num2 = 340

    val highestNum = if (num1 > num2) num1 else num2
    println("Highest between $num1 and $num2 : $highestNum")

    // when - same as switch
// when - as statement

    var marks : Any = 80

    when (marks) {
        100 -> println("Excellent")
        in 75..100 -> {
            println("Passed with")
            println("Distinction")
        }
        in 65..75 -> println("First class")
        in 55..65 -> println("Second class")
        in 35..55 -> println("Third class")
        else -> println("Failed")

    }

    // when - as expression
    var grade : String

    marks = 50
    grade = when (marks) {
        in 75..100 -> {
            println("Distinction")
            "A+"
        }
        in 65..75 -> "A"
        in 55..65 -> "B+"
        in 35..55 -> "B"
        else -> "C"
    }

    println("Grade: $grade")

    val name = "1John"

    // is name starting with vowel, consonant, space, digit, any other char

    when (name.first().lowercase()) {
        "a", "e", "i","o", "u" -> println("Name starts with vowel") //aggregated values
        " " -> println("Name starts with space")
        in "a".."z" -> println("Name starts with Consonant")
        in "0".."9" -> println("Name starts with digit")
        else -> println("Name starts with special char ${name.first()}")
    }

    val firstCh = name.first().lowercase()
    val vowelArray = arrayOf("a", "e", "i", "o", "u")
    when {
        firstCh in vowelArray -> println("Name starting with vowel")
        firstCh == " " -> println("Name starts with space")
        firstCh in "0".."9" -> println("Name starts with digit")
        firstCh in "a".."z" -> println("Name starts with Consonant")
        else -> println("Name starts with special char $firstCh")
    }

    var percentage : Any = -67

    when  {
        percentage !is Int -> println("Not valid")
        percentage < 0 -> println("Marks should not be negative")
        else -> println("Valid marks")
    }
}