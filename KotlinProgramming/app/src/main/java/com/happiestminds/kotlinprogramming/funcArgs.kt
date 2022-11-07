package com.happiestminds.kotlinprogramming



fun main() {
    var result = addTwoInts(10, 20)
    println("Add result: $result")

    displayInfo("John", 30, "New york")
    // named arguments - useful when more parameters
    displayInfo(age = 40, name = "merry", city = "Phoenix")

    calculateEMI(1000, 20)
    calculateEMI(1000)
    calculateEMI(1000 , duration = 24)

    joinStrs()
    joinStrs("john","merry", "robert", delimiter = "*")
}

//1. required arguments
fun addTwoInts (a: Int, b: Int):Int {
    return a + b
}

//2. named arguments
fun displayInfo(name: String, age: Int, city: String){
    println("Name: $name")
    println("Age: $age")
    println("City: $city")
}

//3. default argument
// more than one - use named arguments
// Good practice - place after required args
fun calculateEMI(amount: Int, rate: Int = 10, duration: Int = 12){
    println("Amount: $amount")
    println("Rate: $rate")
    println("Duration: $duration")

    val emi = amount * rate/100/duration
    println("EMI: $emi")
}

//4. variable length arguments
// can have only one
fun joinStrs(vararg inputs: String, delimiter: String = "-"){
    println("No of arguments: ${inputs.size}")
    var result = ""
    for (inp in inputs){
        result += inp + delimiter
    }
    println("Joined : $result")
}