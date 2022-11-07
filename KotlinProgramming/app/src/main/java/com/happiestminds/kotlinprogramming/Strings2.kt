package com.happiestminds.kotlinprogramming

fun main() {

    var msg = "Hi! Hello! How are you?"

    println(msg)

    println("Is this a question? ${msg.endsWith('?')}")
    println("First 5 chars: ${msg.substring(0, 5)}")
    println("all lowercased: ${msg.lowercase()}")
    println("'!' present: ${msg.contains('!')}")
    println("'!' is found at index: ${msg.indexOf('!')}")

    val replaced = msg.replace('!', '*')
    println("Replaced : $replaced")

    msg += "---"

    println(msg)

    // raw string
    var address = """
        HappiestMinds
        Electronic City
        Bangalore
        India
    """.trimIndent()

    val lines = address.lines()
    println("Count of lines: ${lines.size}")

    val words = msg.split(' ')
    println("Split result: $words")

    val removed = msg.removeSuffix("---")
    println("Suffix removed: $removed")

    val reversedMsg = msg.reversed()
    println("Reversed: $reversedMsg")

    val msg1 = "hello"
    val msg2 = "xyz"

    if (msg1 == msg2) {
        println("Same...")
    }
}












