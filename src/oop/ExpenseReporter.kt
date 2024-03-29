package oop

/**
 * link : https://github.com/msbaek/expense
 */
class ExpenseReporter(
    private val expenseExport: ExpenseReport,
    private var printer: ReportPrinter,
    private val expenseNamer: ExpenseNamer
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
                if (expense.isOverage()) "X" else " ",
                getName(expense), penniesToDollars(expense.amount)
            )
        )
    }

    private fun getName(expense: Expense) =
        expenseNamer.getName(expense)

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

class ExpenseReportName : ExpenseNamer {
    override fun getName(expense: Expense) =
        when (expense) {
            is DinnerExpense -> "Dinner"
            is BreakFastExpense -> "Breakfast"
            is CarRentalExpense -> "Car Rental"
            else -> ""
        }
}

interface ExpenseNamer {
    fun getName(expense: Expense): String
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
        if (expense.isMeal())
            mealExpenses += expense.amount
        total += expense.amount
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

}

interface ReportPrinter {
    fun print(text: String?)
}
