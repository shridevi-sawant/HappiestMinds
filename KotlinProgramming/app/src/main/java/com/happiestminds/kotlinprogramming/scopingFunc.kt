package com.happiestminds.kotlinprogramming

fun main() {

    // let, run, with -> return lambda result
    val name = "Elizabeth"
    // count of vowels

    val vCount = getVowelCount(name)
    println("No of vowels in $name: $vCount")

    name.let {
        val count = getVowelCount(it)
        println("No of vowels found in $it : $count")
    }

    // let, run - useful to do null checks
    val city: String? = "abcdefg"
    // let - passing object to other functions
    var vowelCount = city?.let {
        println("-------------")
        val count = getVowelCount(it)
        println("No of vowels found in $it : $count")
        count
    }

    println("VowelCount : $vowelCount")

    // run - when executing operation on the object
    val updatedCity = city?.run {
        val cityU = this.uppercase()
        println("City: $cityU")
        cityU
    }

    //with - non-extension function
    val updatedName = with("john") {
        val nameU = uppercase()

        if (length >= 5) nameU else "*$nameU*"
    }
    println("Updated Name: $updatedName")

    // apply, also -> return object
    // used immediately after object creation

    val data = Array(4){
        it * 1
    }

    println("Elements: ${data.contentToString()}")

    // apply - after object creation for extra initialization
    // also - after object creation for doing additional
            // operation on the new object
    val numbers = IntArray(5).apply {
        this[0] = 10
        this[1] = 20
    }.also {
        println("Elements: ${it.contentToString()}")
        println("isEmpty? ${it.isEmpty()}")
        println("size: ${it.size}")
    }

    numbers[0] = numbers.first().let {
        it * 2
    }

    println(numbers.contentToString())


}

fun getVowelCount(str: String): Int{
    var vowelCount = 0
    val vowelArray = arrayOf('a', 'e', 'i','o','u')
    for (ch in str){
        if (vowelArray.contains(ch))
            vowelCount++
    }

    return vowelCount
}