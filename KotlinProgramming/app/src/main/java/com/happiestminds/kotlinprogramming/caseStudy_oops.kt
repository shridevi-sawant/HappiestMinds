package com.happiestminds.kotlinprogramming

/*
Class BankAccount
    - accNumber
    - Name
    - balance

    - interestRate - 10

    - displayInfo()
    - calculateInterest(duration)
*/

open class BankAccount(val accNum : Int, var name: String ) {
    var balance: Double = 0.0
    open val interestRate = 10

    fun displayInfo(){
        println("Name: $name")
        println("Acc No: $accNum")
        println("Interest Rate: $interestRate")
        println("Balance: $balance")
    }

    fun calculateInterest(duration: Int){
        println("Interest for $duration months: ${duration * interestRate}")
    }
}

/*
class SavingAccount : BankAccount
    - interestRate - 12

    - credit(amount)
    - debit(amount)

class FDAccount: BankAccount
    - interestRate - 15

    - credit(amount)

 */

class SavingAccount(number: Int, name: String): BankAccount(number, name) {
    override val interestRate = 12

    fun credit(amount: Double){
        balance += amount
    }

    fun debit(amount: Double){
        if (balance < amount){
            println("Insufficient balace")
        }
        else {
            balance -= amount
        }
    }
}

data class AdharRecord(val adhNo: Int, var name: String, var city: String ,var mobile: String)

class AdharDB {
    var db: MutableMap<Int, AdharRecord> = mutableMapOf()

    fun addRecord(adhar: Int, name:String, city:String, mobile: String){
        db[adhar] = AdharRecord(adhar,name, city, mobile)

    }

    fun printDetails(adharNo: Int){
        if (db.containsKey(adharNo)){
            val record = db[adharNo]
            println("Details: $record")
        }else {
            println("No record found for adhar $adharNo")
        }

    }

    fun printDetailsForCity(city: String) {
        println("--- Records belonging to city $city:")
        for (record in db.values) {
            if (record.city == city){
                println(record)
            }
        }
    }
}

fun main() {
    val adharDb = AdharDB()
    adharDb.addRecord(1, "John", "Pune", "111")
    adharDb.addRecord(2, "Merry", "Pune", "222")
    adharDb.addRecord(3, "Robert", "Bangalore", "333")
    println(adharDb.db)

    adharDb.printDetails(3)
    adharDb.printDetails(30)
    adharDb.printDetailsForCity("Pune")
}

/*
Class AdharDB {
    Map -> Adhar details

}

Each record -
 class AdharRecord
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

