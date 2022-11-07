package com.happiestminds.kotlinprogramming

fun main() {
    val personNames = arrayOf("john", "merry", null, "robert", null, "elizabeth") // Array<String?>

    // 1. count of vowels
    // 2. longest name

    var nameL = personNames[0]

    for (name in personNames) {

        // convert nullable to non-nullable - Elvis (null-coalescing) operator
        val fName = name ?: ""
        var vowelCount = 0
        for (ch in fName) {
            when (ch) {
                'a', 'e', 'i','o','u' -> vowelCount++
            }
        }

        println("No of vowels in $fName: $vowelCount")

        val maxLenght = nameL?.length ?: 0
        if (maxLenght < fName.length) {
            nameL = fName
        }
    }

    println("Longest name: $nameL")

    /*
    1. print only valid phone numbers - 10 digits
    2. if number is invalid, make it null
     */

    var phNumbers = arrayOf("123", "456", null, "1234567890", null, "9876543210")

    //1. using explicit check
    for (idx in phNumbers.indices){
        val phone = phNumbers[idx]
        if (phone != null){
            if (phone.length == 10){
                println("Valid Phone number: $phone")
            }
            else {
                phNumbers[idx] = null
            }
        }
    }

    println("Updated numbers: ${phNumbers.contentToString()}")

    // 2. using elvis operator
    println("----- Using Elvis operator ----")
    phNumbers = arrayOf("123", "456", null, "1234567890", null, "9876543210")
    for (idx in phNumbers.indices){
        val phone = phNumbers[idx] ?: ""

        if (phone.length == 10){
            println("Valid Phone number: $phone")
        }
        else {
            phNumbers[idx] = null
        }

    }
    println("Updated numbers: ${phNumbers.contentToString()}")

    // 3. using safe-call operator
    println("----- Using safe-call and Elvis operator ----")
    phNumbers = arrayOf("123", "456", null, "1234567890", null, "9876543210")
    for (idx in phNumbers.indices){
        val noOfDigits = phNumbers[idx]?.length ?: 0

        if (noOfDigits == 10){
            println("Valid Phone number: ${phNumbers[idx]}")
        }
        else {
            phNumbers[idx] = null
        }

    }

    println("Updated numbers: ${phNumbers.contentToString()}")

}