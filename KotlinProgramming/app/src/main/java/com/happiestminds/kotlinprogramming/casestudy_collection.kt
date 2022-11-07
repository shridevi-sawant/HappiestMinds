package com.happiestminds.kotlinprogramming

/*
Map -> Adhar details

Each record
        - adhar No (key)
        - name
        - mobile
        - city

adharDB = {"123" = {"name": "John", "mobile": "12232", "city": "Pune"}}

adharDB["123"]["mobile"]

// functions
    - addRecord(adhar, name, city, mobile)
    - printDetails(adharNo)
    - printDetailsForCity(city)

 */
fun main() {
     val names = listOf("john", "merry", "robert", "elizabeth", "mike", "tom", "jerry")
/*
1. Names starting with vowel - filter
2. largest name - reduce
3. Names with more than 5 chars - filter
4. Convert all names to uppercase - map
 */

    val vowelArray = arrayOf('a', 'e','i','o','u')
    val namesStartingWithVowel = names.filter {
        it.first() in vowelArray
    }

    println(namesStartingWithVowel)

    val largestName = names.reduce { largest, element ->
        if (largest.length > element.length) largest else element
    }

    println("Largest : $largestName")

    val accounts = listOf("123a", "987", "1209", "123456789012", "987654321098")

/*
1. valid account number (12 digit) - filter
2. replace invalid account numbers with "" (Empty string) - map
 */

   val validAcc = accounts.filter {
       it.length == 12 && it.toLongOrNull() != null
//        when {
//            it.toLongOrNull() == null -> false
//            it.length == 12 -> true
//            else -> false
//        }
    }

    println("Valid acc: $validAcc")

    val updatedAcc = accounts.map {
        when {
            it.toLongOrNull() == null -> ""
            it.length == 12 -> it
            else -> ""
        }
    }

    println("Updated: $updatedAcc")
}