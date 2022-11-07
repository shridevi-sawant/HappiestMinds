package com.happiestminds.kotlinprogramming

// class definition
class Student(
    val id: Int,
    var name: String
) {
    // data members/properties
    var marks = 0
    var branch = "" // instance property

    companion object {
        var stdCount = 0 // class property
        val totalMarks = 600
    }

    init {
        // executed when object is created
        println("Init executed")
        stdCount++
    }

    //Rule - If class has primary constructor, secondary constructors should execute it
    constructor(id: Int, name: String, marks: Int) : this(id, name) {
        this.marks = marks
    }

    constructor(id: Int, name: String, branch: String, marks: Int = 0) : this(id, name, marks) {
        this.branch = branch
    }

    // methods
    fun displayInfo() {
        println("Student Id: $id")
        println("Student Name: $name")
        println("Student Marks: $marks")
    }
}

// via extension method to calculate percentage

fun Student.calculatePerc() : Double {
    return this.marks.toDouble()  / Student.totalMarks * 100
}


fun main() {

    val std1 = Student(1, "John Smith")
    std1.displayInfo()

    val mStd = std1
        //Student(1, "John Smith")

    // === references are matched
    if (std1 === mStd){
        println("Same")
    }else{
        println("Different")
    }



//    val std2 = Student(2, "Merry Smith")
//    std2.displayInfo()
//
//    val std3 = Student(3, "Robert", 88)
//    std3.displayInfo()
//
//    val std4 = Student(4, "Tom", "Electronics", 590)
//    std4.displayInfo()
//    println("Percentage: ${std4.calculatePerc()}")
//
//    val std5 = Student(5, "Jerry", "CS")
//    std5.displayInfo()
//
//    println("Student Count: ${Student.stdCount}")


}

