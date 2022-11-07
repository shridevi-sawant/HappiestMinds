package com.happiestminds.testingdemo

class MathUtility {

    fun add(a: Int, b: Int) : Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int? {

        return if (b==0) null else a/b

    }

    fun isEven(num: Int): Boolean {

        return (num % 2 == 0)
    }
}