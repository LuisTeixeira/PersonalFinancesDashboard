import kotlinx.html.InputType
import kotlinx.html.js.onBlurFunction
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onFocusOutFunction
import kotlinx.html.onBlur
import kotlinx.html.onChange
import models.Transaction
import models.TransactionImpl
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.input
import react.dom.p

external interface AddTransactionProps: RProps {
    var isExpense: Boolean
    var onTransactionAdded: (Transaction) -> Unit
}

external interface AddTransactionState: RState{
    var date: String?
    var description: String?
    var transactionValue: Double?
}

@JsExport
class AddTransaction: RComponent<AddTransactionProps, AddTransactionState>() {

    override fun AddTransactionState.init() {
        date = null
        description = null
        transactionValue = 0.0
    }

    override fun RBuilder.render() {
        p{
            input {
                attrs{
                    type = InputType.date
                    onChangeFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            date = target.value
                        }
                    }
                }
            }
            input {
                attrs{
                    type = InputType.text
                    onChangeFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            description = target.value
                        }
                    }
                }
            }
            input {
                attrs{
                    type = InputType.number
                    onBlurFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            transactionValue = target.value.toDouble()
                        }
                    }
                }
            }
            input {
                attrs{
                    type = InputType.button
                    value = "Add"
                    onClickFunction = {
                        props.onTransactionAdded(TransactionImpl(state.description!!, state.transactionValue!!, state.date!!))
                    }
                }
            }
        }
    }
}

fun RBuilder.addTransaction(handler: AddTransactionProps.() -> Unit): ReactElement{
    return child(AddTransaction::class){
        this.attrs(handler)
    }
}