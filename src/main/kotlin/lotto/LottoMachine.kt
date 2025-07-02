package lotto

class LottoMachine(val purchaseAmount: Int) {
    init {
        require(purchaseAmount in MIN..MAX) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN = 1000
        private const val MAX = 20000
    }
}