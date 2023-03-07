package oop

import oop.Expense.Type.*

/**
 * link : https://github.com/msbaek/expense
 */
class ExpenseReport {
    private val expenses: MutableList<Expense> = ArrayList()

    fun printReport(printer: ReportPrinter) {
        var total = 0
        var mealExpenses = 0
        printHeader(printer)
        for (expense in expenses) {
            if (expense.type === BREAKFAST || expense.type === DINNER)
                mealExpenses += expense.amount

            total += expense.amount
        }

        for (expense in expenses) {
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
                    name, penniesToDollars(expense.amount)
                )
            )
        }

        printToTotal(printer, mealExpenses, total)
    }

    private fun printToTotal(
        printer: ReportPrinter,
        mealExpenses: Int,
        total: Int
    ) {
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(mealExpenses)))
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(total)))
    }

    private fun printHeader(printer: ReportPrinter) {
        printer.print("Expenses $date\n")
    }

    private fun penniesToDollars(amount: Int) =
        amount / 100.0

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
