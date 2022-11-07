package com.happiestminds.kotlinprogramming

import kotlin.math.sqrt

fun main() {

    /*
    1. prime numbers between 1 to 20
        - exactly two divisor - 1 and number itself */

    for (num in 2..20) {
        var isPrime = true
        for (divisor in 2..sqrt(num.toDouble()).toInt()) {
            if (num  % divisor == 0){
                isPrime = false
                break
            }
        }

        if (isPrime) {
            println("$num is prime")
        }
    }



/*
    2. array of numbers - highest number and lowest number
        val data = arrayOf(10,30,23,4,1,100,34)

     */
    val data = arrayOf(10,30,23,4,1,100,34)
    var maxNum = data[0]

    var counter : Int?
    counter = null

    var minNum = data[0]

    for (num in data) {
        maxNum = if (maxNum > num) maxNum else num
        minNum = if (minNum < num) minNum else num
    }

    println("MAx : $maxNum")
    println("Min: $minNum")








    /*


    3. val sentence = "Kotlin is a multiplatform language"

        count of vowels, count of consonants, count of spaces, count of digits, count of special chars

        - get string with all vowels removed

     */
    var sentence = "Kotlin is a multiplatform language"

    var vowels = 0
    var consonants = 0
    var digits = 0
    var spaces = 0
    var extra = 0

    sentence = sentence.lowercase()
    for (ch in sentence) {

        when(ch){
            'a','e','i','o','u' -> ++vowels
            in 'a'..'z' -> ++consonants
            in '0'..'9' -> ++digits
            ' ' -> ++spaces
            else -> extra++
        }

    }

    println("Vowels: $vowels")
    println("Consonants: $consonants")
    println("Digits: $digits")
    println("White spaces: $spaces")

    println("Total: ${sentence.length}, ${vowels + consonants + digits + spaces + extra}")


    /*
    4. var logdata = """
        This is error log #2 abc
        This is debug log #10
        This is error log #12
        This is error log #30 xyz
        This is debug log #15
    """.trimIndent()

            /*
            Total number of logs
            Total error logs
            Total debug logs

            for error logs, print log error no

             */


     */

    val logdata = """
        This is error log #2 abc
        This is debug log #10
        This is error log #12
        This is error log #30 xyz
        This is debug log #15
    """.trimIndent()
    val lines = logdata.lines()
    var errCount = 0
    var debugCount = 0

    println("Total: ${lines.size}")
    for (line in lines){
        when{
            line.contains("error") ->
            {
                errCount++
                val hashPos=line.indexOf('#')
                val spacePos = line.indexOf(' ',hashPos)
                var errNo = ""
//                if (spacePos != -1)
//                    errNo = line.substring(hashPos+1, spacePos)
//                else
//                    errNo = line.substring(hashPos+1)
                errNo = if (spacePos != -1)
                    line.substring(hashPos+1, spacePos)
                else
                    line.substring(hashPos+1)
                println("Error log number: $errNo")
            }
            line.contains("debug") -> debugCount++
        }

    }

    println("Error Count: $errCount")
    println("Debug Count: $debugCount")

    /////////



}