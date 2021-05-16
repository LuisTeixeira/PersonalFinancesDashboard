package models

external interface Transaction {
    val description: String
    val value: Double
    val date: String
}

data class TransactionImpl(
    override val description: String,
    override val value: Double,
    override val date: String,
) : Transaction