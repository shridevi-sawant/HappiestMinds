package com.happiestminds.kotlinprogramming

internal open class Employee(val empId: Int, var name: String, var city: String = "Bangalore"){
    open val bonus = 100

    companion object{
        var empCount = 0

    }
    init {
        empCount++
    }

    open fun displayInfo(){
        println("Emp Id: $empId")
        println("Emp Name: $name")
        println("Emp City: $city")
        println("Emp Bonus: $bonus")
    }

}

private class Developer(id:Int,
                devName: String,
                city: String,
                var skill: String): Employee(id, devName,city) {

    override val bonus = 200

    override fun displayInfo() {
        println("-----Developer -----")
        super.displayInfo()
        println("Developer Skills: $skill")
    }
}

private class Tester : Employee {
    override val bonus = 150

    var tool: String = ""
    constructor(id: Int, tName: String,
                tCity: String, testingTool: String) : super(id, tName,tCity){
        tool = testingTool
    }

    override fun displayInfo() {
        println("----Tester-----")
        super.displayInfo()
        println("Testing tool: $tool")
    }

}

fun main() {

    val emp1 = Employee(1, "John")
    val emp2 = Developer(2, "Merry", "Pune", "Kotlin")
    val emp3 = Tester(3, "Robert", "New York", "Selenium")

    val empList = listOf(emp1, emp2, emp3)

    // runtime polymorphism - method overriding
    for (emp in empList){
        //emp.displayInfo()
        when (emp) {
            is Developer -> println("Developer skill: ${emp.skill}")
            is Tester -> println("Tester tool: ${emp.tool}")
        }

        // as - type casting operator
        // is - type check operator
        println((emp as? Developer)?.skill)
    }

    //println("Total employees: ${Employee.empCount}")
    //println(emp1)

}