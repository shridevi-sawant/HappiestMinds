package com.happiestminds.kotlinprogramming

open class Account(val accNo: String, var name: String) {
    open val interestRate = 10
    var balance = 0.0

    fun displayInfo(){
        println("Acc Number: $accNo")
        println("Acc Name: $name")
        println("Interest RAte: $interestRate")
        println("Balance: $balance")
    }

    fun calculateInterest(duration: Int){
        println("Interest for $duration months: ${duration * interestRate * balance}")
    }
}

interface CreditInterface {
    fun credit(amount: Double)

}

interface DebitInterface {
    fun debit(amount: Double)
}

class SavingsAccount(number:String, name:String): Account(number, name),
    CreditInterface,
    DebitInterface {

    override val interestRate = 12
    override fun credit(amount: Double) {
        balance += amount
    }

    override fun debit(amount: Double) {
        if (balance > amount){
            balance -= amount
        }else
            println("Insufficient balance")
    }

}

class FDAccount(number:String, name: String) : Account(number, name), CreditInterface {
    override val interestRate = 15

    companion object {
        const val MAX_CREDIT_AMOUNT = 1_00_000
    }
    override fun credit(amount: Double) {
        if (amount < MAX_CREDIT_AMOUNT)
            balance += amount
        else
            println("AMount cannot be higher than $MAX_CREDIT_AMOUNT")
    }

}

fun main() {
    val acc1 = SavingsAccount("12-12", "John")
    acc1.credit(1000.0)
    acc1.debit(500.0)
    acc1.displayInfo()

    val acc2 = FDAccount("093-13", "Merry")
    acc2.credit(99_999.0)
    acc2.displayInfo()
}