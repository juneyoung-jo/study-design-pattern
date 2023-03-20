package oop

abstract class Expense(
    val amount: Int
) {
    abstract fun isMeal(): Boolean
    abstract fun isOverage(): Boolean
}

class DinnerExpense(
    amount: Int
) : Expense(amount) {
    override fun isMeal(): Boolean = true
    override fun isOverage(): Boolean = amount > 5000
}

class BreakFastExpense(
    amount: Int
) : Expense(amount) {
    override fun isMeal(): Boolean = true
    override fun isOverage(): Boolean = amount > 1000
}

class CarRentalExpense(
    amount: Int
) : Expense(amount) {
    override fun isMeal(): Boolean = false
    override fun isOverage(): Boolean = false
}
