package lotto

data class TicketCounter(
    val purchaseAmount: PurchaseAmount,
    val enteredTicketCount: EnteredTicketCount,
) {
    var generatedTicketCount = 0

    init {
        val purchasableTickets = purchaseAmount.amount / LottoMachine.TICKET_PRICE
        require(enteredTicketCount.count <= purchasableTickets) { COUNT_ERROR_MESSAGE }
        generatedTicketCount = purchasableTickets - enteredTicketCount.count
    }

    companion object {
        private const val COUNT_ERROR_MESSAGE = "Count should be less than Purchasable Tickets"
    }
}
