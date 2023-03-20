package oop

import oop.Expense.Type.*

abstract class Expense(
    val type: Type,
    val amount: Int
) {
    enum class Type {
        DINNER, BREAKFAST, CAR_RENTAL
    }

    abstract fun isMeal(): Boolean
    abstract fun isOverage(): Boolean
}

class DinnerExpense(
    amount: Int
) : Expense(DINNER, amount) {
    override fun isMeal(): Boolean = true
    override fun isOverage(): Boolean = amount > 5000
}

class BreakFastExpense(
    amount: Int
) : Expense(BREAKFAST, amount) {
    override fun isMeal(): Boolean = true
    override fun isOverage(): Boolean = amount > 1000
}

class CarRentalExpense(
    amount: Int
) : Expense(CAR_RENTAL, amount) {
    override fun isMeal(): Boolean = false
    override fun isOverage(): Boolean = false
}
