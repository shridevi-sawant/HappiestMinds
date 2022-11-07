package com.happiestminds.kotlinprogramming

fun main() {
    // List
    //val langList = listOf("C", "C++", "Python") // immutable list
    val langList = mutableListOf<String>().apply {
        add("C")
        add(0, "C++")
        add("Python")
    } // mutable

//    langList.add("C") // append
//    langList.add(0, "C++") // insert
//    langList.add("Python")

    println("List: $langList")
    println("No of elements: ${langList.size}")
    println("First element: ${langList[0]}")
    println("First element: ${langList.first()}")
    println("Last element: ${langList.last()}")

    for (lang in langList){
        println("Language: $lang")
    }

    langList.forEach {
        println("Language: ${it.uppercase()}")
    }

    for (idx in langList.indices) {
        println("Element at $idx : ${langList[idx]}")
    }

    if (langList.contains("Python")){ //("Python" in langList){
        println("Index of 'python': ${langList.indexOf("Python")}")
    }

    println("First two elements: ${langList.subList(0,2)}")

    val functionalLangs = listOf("Swift", "Kotlin", "Python", "Dart")

   // langList += functionalLangs
    langList.addAll(functionalLangs)
    println("Concated: $langList")

    // removal
    while ("Python" in langList) {
        langList.remove("Python")
    }

    langList[0] = "GoLang" // update

    println("After removal: $langList")
    // Set

    // Map

}