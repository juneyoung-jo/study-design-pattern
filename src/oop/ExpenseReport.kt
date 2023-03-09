package oop

import oop.Expense.Type.*

/**
 * link : https://github.com/msbaek/expense
 */
class ExpenseReport(
    private val expenses: MutableList<Expense> = ArrayList(),
    private var total: Int = 0,
    private var mealExpenses: Int = 0,
    private var printer: ReportPrinter
) {

    fun printReport(printer: ReportPrinter) {
        this.printer = printer
        totalUpExpenses()
        printExpensesAndTotals()
    }

    private fun printExpensesAndTotals() {
        printHeader()
        printExpenses()
        printToTotal()
    }

    private fun totalUpExpenses() {
        for (expense in expenses) {
            if (isMeal(expense))
                mealExpenses += expense.amount

            total += expense.amount
        }
    }

    private fun isMeal(expense: Expense) =
        expense.type === BREAKFAST || expense.type === DINNER

    private fun printExpenses() {
        for (expense in expenses) {
            printExpense(expense)
        }
    }

    private fun printExpense(expense: Expense) {
        printer.print(
            String.format(
                "%s\t%s\t$%.02f\n",
                if (expense.type === DINNER && expense.amount > 5000
                    || expense.type === BREAKFAST && expense.amount > 1000
                ) "X" else " ",
                getName(expense), penniesToDollars(expense.amount)
            )
        )
    }

    private fun getName(expense: Expense) =
        when (expense.type) {
            DINNER -> "Dinner"
            BREAKFAST -> "Breakfast"
            CAR_RENTAL -> "Car Rental"
        }

    private fun printToTotal() {
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(mealExpenses)))
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(total)))
    }

    private fun printHeader() {
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
