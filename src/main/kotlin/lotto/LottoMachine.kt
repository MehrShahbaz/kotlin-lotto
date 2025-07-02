package lotto

class LottoMachine(val purchaseAmount: Int) {
    private var change = 0

    init {
        require(purchaseAmount in MIN..MAX) {
            throw IllegalArgumentException()
        }
        change = purchaseAmount % TICKET_AMOUNT
    }

    fun showChange() = change

    companion object {
        private const val MIN = 1000
        private const val MAX = 20000
        private const val TICKET_AMOUNT = 1000
    }
}