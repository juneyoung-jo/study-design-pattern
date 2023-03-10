package oop

import oop.Expense.Type.*

/**
 * link : https://github.com/msbaek/expense
 */
class ExpenseReporter(
    private val expenseExport: ExpenseReport,
    private var printer: ReportPrinter
) {

    fun printReport(printer: ReportPrinter) {
        this.printer = printer
        expenseExport.totalUpExpenses()
        printExpensesAndTotals()
    }

    private fun printExpensesAndTotals() {
        printHeader()
        printExpenses()
        printToTotal()
    }

    private fun printExpenses() {
        for (expense in expenseExport.expenses) {
            printExpense(expense)
        }
    }

    private fun printExpense(expense: Expense) {
        printer.print(
            String.format(
                "%s\t%s\t$%.02f\n",
                if (isOverage(expense)) "X" else " ",
                getName(expense), penniesToDollars(expense.amount)
            )
        )
    }

    private fun isOverage(expense: Expense) =
        (expense.type === DINNER && expense.amount > 5000)
                || (expense.type === BREAKFAST && expense.amount > 1000)

    private fun getName(expense: Expense) =
        when (expense.type) {
            DINNER -> "Dinner"
            BREAKFAST -> "Breakfast"
            CAR_RENTAL -> "Car Rental"
        }

    private fun printToTotal() {
        printer.print(String.format("\nMeal expenses $%.02f", penniesToDollars(expenseExport.mealExpenses)))
        printer.print(String.format("\nTotal $%.02f", penniesToDollars(expenseExport.total)))
    }

    private fun printHeader() {
        printer.print("Expenses $date\n")
    }

    private fun penniesToDollars(amount: Int) =
        amount / 100.0

    private val date: String
        get() = "9/12/2002"
}

class ExpenseReport(
    val expenses: MutableList<Expense> = ArrayList(),
    var total: Int = 0,
    var mealExpenses: Int = 0,
) {
    fun totalUpExpenses() {
        for (expense in expenses) {
            addTotals(expense)
        }
    }

    fun addTotals(expense: Expense) {
        if (isMeal(expense))
            mealExpenses += expense.amount
        total += expense.amount
    }

    fun isMeal(expense: Expense) =
        expense.type === BREAKFAST || expense.type === DINNER

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

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
