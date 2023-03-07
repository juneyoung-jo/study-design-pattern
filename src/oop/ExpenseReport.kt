package oop

import oop.Expense.Type.*


class ExpenseReport {
    private val expenses: MutableList<Expense> = ArrayList()

    fun printReport(printer: ReportPrinter) {
        var total = 0
        var mealExpenses = 0
        printer.print("Expenses $date\n")
        for (expense in expenses) {
            if (expense.type === BREAKFAST || expense.type === DINNER) mealExpenses += expense.amount
            var name = "TILT"
            name = when (expense.type) {
                DINNER -> "Dinner"
                BREAKFAST -> "Breakfast"
                CAR_RENTAL -> "Car Rental"
            }
            printer.print(
                String.format(
                    "%s\t%s\t$%.02f\n",
                    if (expense.type === DINNER && expense.amount > 5000
                        || expense.type === BREAKFAST && expense.amount > 1000
                    ) "X" else " ",
                    name, expense.amount / 100.0
                )
            )
            total += expense.amount
        }
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0))
        printer.print(String.format("\nTotal $%.02f", total / 100.0))
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    private val date: String
        get() = "9/12/2002"
}


class Expense(
    val type: Type,
    val amount: Int
) {
    enum class Type {
        DINNER, BREAKFAST, CAR_RENTAL
    }
}

interface ReportPrinter {
    fun print(text: String?)
}
