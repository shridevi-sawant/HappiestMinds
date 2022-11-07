package com.happiestminds.kotlinprogramming

fun main() {
    var firstName = "John" // escaped string
    val lastName = "Smith"

    var fullName = "$firstName $lastName" // string interpolation/ templating
        //firstName + " " + lastName // using concat
    println("Fullname: $fullName")

    var address: String
    address = """
        HappiestMinds
        Electronic City
        Bangalore
        India
    """.trimIndent() // raw String

    println("Addr: $address")

    val uppered = fullName.uppercase()

    println(uppered)
    println("No of chars : ${fullName.length}")
    println("First char: ${fullName.first()}")
    println("Last Char: ${fullName.last()}")    // ${fullName[fullName.lastIndex]}")
    println("IS string empty: ${fullName.isEmpty()}")
    println("is space available? ${fullName.contains(' ')}")


}