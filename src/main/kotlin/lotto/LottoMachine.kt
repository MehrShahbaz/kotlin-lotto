package lotto

class LottoMachine(
    val purchaseAmount: Int,
    val tickets: MutableList<Lotto> = emptyList<Lotto>().toMutableList(),
) {
    private var change = 0
    private var ticketCount = 0

    init {
        require(purchaseAmount in MIN..MAX)
        change = purchaseAmount % TICKET_PRICE
        ticketCount = (purchaseAmount - change) / TICKET_PRICE
        generateTickets()
    }

    fun showChange() = change

    private fun generateTickets() {
        val lottoTickets = List(ticketCount) { Lotto(generateNumbers()) }
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
        private const val MIN = 1_000
        private const val MAX = 20_000
        const val TICKET_PRICE = 1_000
    }
}
