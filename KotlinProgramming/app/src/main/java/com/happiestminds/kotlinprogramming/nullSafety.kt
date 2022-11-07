package com.happiestminds.kotlinprogramming

fun main() {

    var name = "john" // non-nullabel string
    println("length: ${name.length}")

    var address: String? // nullable
    address = null
   // address = "bangalore"

    // 1. explicit check on null
    if (address != null) {
        val noOfChar = address.length
        println(noOfChar)
    }
    else {
        println("No value in address")
    }

    // 2. safe-call operator- ?.
    address = null
    var charCount = address?.length // access to property only when its not null; if null returns null

    println("Char Count: $charCount")

    // 3. elvis operator ?: - default value(right side)
    // Rule - left and right operand of same type
    address = "pune"
    var chCount = address?.length ?: 0
    println("Char count: $chCount")

    // 4. Not-null assertion operator - !! - NPE if value is null
    val pincode: String? = "abc"

    println("Length : ${pincode!!.length}")

    val data = arrayOf(1,2,null,3,4,null) // Array<Int?>

    for (num in data ){
        if (num != null) {
            // smart -casting
            val sqr = num * num
            println("Square of $num: $sqr")
        }

    }


}