import kotlinx.html.InputType
import models.Transaction
import models.TransactionImpl
import react.*
import react.dom.*

external interface AppState: RState {
    var expenses: List<Transaction>
    var incomes: List<Transaction>
}

@JsExport
class App: RComponent<RProps, AppState>(){
    override fun RBuilder.render() {

        h3 {
            +"Expenses"
        }
        transactionList {
            transactionList = state.expenses
        }

        addTransaction{
            onTransactionAdded = { transaction ->
                setState {
                    expenses += transaction
                }
            }
        }

        h3 {
            +"Income"
        }
        transactionList {
            transactionList = state.incomes
        }
        addTransaction{
            onTransactionAdded = { transaction ->
                setState {
                    incomes += transaction
                }
            }
        }
    }

    override fun AppState.init() {

        expenses = mutableListOf(
            TransactionImpl("Rent", 1200.00, "03/05/2021"),
            TransactionImpl("Insurance", 30.00, "02/05/2021"),
            TransactionImpl("Groceries", 1200.00, "04/05/2021"),
            TransactionImpl("Power", 49.99, "10/05/2021"),
            TransactionImpl("Internet", 39.99, "03/05/2021"),
            TransactionImpl("Mobile", 15.00, "03/05/2021")
        )

        incomes = mutableListOf(
            TransactionImpl("Salary", 2200.00, "01/05/2021"),
            TransactionImpl("Lea's Rent", 600.00, "02/05/2021"),
        )

    }
}

