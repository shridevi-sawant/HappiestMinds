package com.happiestminds.kotlinprogramming

fun main() {
    var result = 10.divideBy(2)
    println("10/2 = $result")

    result = 10 divideBy 0

    result = getNum("123")
    println("Converted num: $result")

    result = getNum(null)
    println("Converted num: $result")

    try {
        startGame(-10)
    }catch (e: Exception){
        println("Game not started: ${e.message}")
    }
}

// try as expressions
infix fun Int.divideBy(num : Int): Int{
//    try {
//        return this / num
//    }catch(err: ArithmeticException){
//        println("Infinity: ${err.message}")
//    }
//    return -1

    return try {
        this/num
    }catch (e: ArithmeticException){
        println("Infinity: ${e.message}")
        -1
    }
}
//"123"  -> 123
fun getNum(str: String?) : Int {
   return try {
       str!!.toInt()
   }catch (e: Exception){ // generic exception - always at last in order
       0
   }
//   }catch (e: NumberFormatException){
//       0
//   }catch (e: NullPointerException){
//       0
//   }
   finally {
       println("getNum executed...")
   }
}
// throw - built-in exceptions
// throw - user-defined/custom exceptions

fun startGame(level: Int) {
    if (level > 1){
        println("Starting game for level $level")
    }else {
        //throw IllegalArgumentException("Invalid game level..")
        throw MyException("Invalid game level", -1)
    }
}

class MyException(msg: String, val errCode: Int): Exception(msg){

}