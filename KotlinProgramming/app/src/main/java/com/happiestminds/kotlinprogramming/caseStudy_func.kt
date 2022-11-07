package com.happiestminds.kotlinprogramming

fun main() {
    println("5! = ${getFactorial(5)}")

    val factWithLambda = { a: Int ->
        var result = 1
        for (num in 1..a){
            result *= num
        }

        result
    }
    println("With lambda 5! = ${factWithLambda(5)}")

    println("H E L L O".removeSpaces())

    var result = getOperation(1)(10, 20)
    println("Result with flag 1: $result")

    var updatedStr = "Hello".convertStr {
        it.uppercase()
    }

    println(updatedStr)
    updatedStr = "Hello".convertStr {
        it.lowercase()
    }
    println(updatedStr)

    updatedStr = "Hello".convertStr {
        var vowelRemoved = ""
        val vowelArray = arrayOf('a','e','i', 'o', 'u')
        for (ch in it){
            if (ch !in vowelArray)
                vowelRemoved += ch
        }
        vowelRemoved
    }
    println(updatedStr)
}

// write function to calculate factorial of number -  named function and lambda
// n! = n * (n-1)!
// 1! = 1

fun getFactorial(a : Int) : Int {
    return if (a <= 1) 1 else a * getFactorial(a-1)
}


//2. extension function to String which will remove all spaces in the string

fun String.removeSpaces(): String{
    return this.replace(" ", "")
}

//3. function - higher order function
/*
input arg - flag (int)
return value - function for mathematical operations based on flag value;
1- add, 2 - subctract, 3- multiply, 4 -division
 */

fun getOperation(flag: Int): (Int, Int)->Int{
    when (flag){
        1 -> return {a, b -> a + b}
        2 -> return {a, b -> a - b}
        3 -> return {a, b -> a * b}
        else -> return {a, b -> a / b }
    }
}


// 4. Write extension function to String to convert it to another string
//  input arg - function for converting
// return value -  converted string

fun String.convertStr(conversion: (String)-> String) : String {
    return conversion(this)
}

