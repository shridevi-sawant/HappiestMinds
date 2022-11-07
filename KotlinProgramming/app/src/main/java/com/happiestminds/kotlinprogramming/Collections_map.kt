package com.happiestminds.kotlinprogramming

fun main() {
    /*
    map - key-value pair
       - key is index
     */

    val contacts = mutableMapOf( "merry" to 222, Pair("Robert", 333))

    contacts["john"] = 111
    println("Map: $contacts")

    contacts["merry"] = 123
    println("Updated: $contacts")

    val officeContacts = mapOf("john" to 999, Pair("mike", 888), "merry" to 777)

   contacts.putAll(officeContacts)
    println("Merged: $contacts")

    // remove
    if ("john" in contacts) {
        contacts.remove("john")
        println("Removed: $contacts")
    }

    // iterating map

    for ((name, number) in contacts){
        println("Contact # of $name: $number")
    }

    // only keys
    for (name in contacts.keys) {
        println("name: $name, number: ${contacts[name]}")
    }

    // only values
    for (num in contacts.values) {
        println("Number: $num")
    }

    val data = mutableMapOf<String, MutableSet<Int>> ()

    data["john"] = mutableSetOf(111, 222)
}