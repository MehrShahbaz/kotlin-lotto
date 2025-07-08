package lotto

class LottoMachine(
    val ticketCounter: TicketCounter,
    val tickets: MutableList<Lotto> = emptyList<Lotto>().toMutableList(),
) {
    var change = 0
        private set

    init {
        change = ticketCounter.purchaseAmount.amount % TICKET_PRICE
        generateTickets()
    }

    fun manualTicketCount() = ticketCounter.purchaseAmount.amount

    private fun generateTickets() {
        val lottoTickets = List(ticketCounter.generatedTicketCount) { Lotto(generateNumbers()) }
        tickets.addAll(lottoTickets)
    }

    private fun generateNumbers(): List<LottoNumber> =
        NUMBER_LIST
            .shuffled()
            .take(Lotto.LOTTO_SIZE)

    companion object {
        private val NUMBER_LIST =
            (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER)
                .map(LottoNumber::from)
        const val TICKET_PRICE = 1_000
    }
}
