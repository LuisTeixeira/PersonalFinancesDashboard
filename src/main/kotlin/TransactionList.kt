import models.Transaction
import react.*
import react.dom.h3
import react.dom.p
import styled.styledDiv

external interface TransactionListProps: RProps{
    var transactionList: List<Transaction>
}

@JsExport
class TransactionList: RComponent<TransactionListProps, RState>() {

    override fun RBuilder.render() {
        styledDiv {
            for (transaction in props.transactionList) {
                p {
                    +"${transaction.date}\t${transaction.description}\t${transaction.value}€"
                }
            }
        }
    }

}

fun RBuilder.transactionList(handler: TransactionListProps.() -> Unit): ReactElement {
    return child(TransactionList::class){
        this.attrs(handler)
    }
}