package com.happiestminds.kotlinprogramming

data class CoOrdinate(var x: Int, var y: Int) {

    operator fun plus(arg2: CoOrdinate) : CoOrdinate {
        return CoOrdinate(this.x + arg2.x, this.y + arg2.y)
    }

    operator fun minus(arg2: CoOrdinate):CoOrdinate {
        return CoOrdinate(this.x - arg2.x, this.y - arg2.y)
    }

    // exactly takes one parameter
    infix fun growBy(size: Int): CoOrdinate{
        return CoOrdinate(x + size, y+size)
    }
}

infix fun Int.powerOf(expo: Int): Int{
    var result = 1
    for (n in 1..expo){
        result *= this
    }
    return result
}

fun main() {
    val res = 10 powerOf 3
    println("10 raised to 3 = $res")
    val p1 = CoOrdinate(10, 20)
    println(p1)

    val p2 = CoOrdinate(1,1)

    val p3 = p1 + p2
    println(p3)

    val p4 = p1 - p2
    println(p4)
    val p5 = p1 growBy 10
        //p1.growBy(10)
    println(p5)

    mapOf("one" to 1)
    1..10 step 2
}