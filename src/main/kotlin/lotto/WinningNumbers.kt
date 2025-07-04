package lotto

data class WinningNumbers(
    val winningNumbers: Lotto,
    val bonusNumber: Int,
) {
    init {
        require(bonusNumber in Lotto.MIN..Lotto.MAX)
        require(!winningNumbers.numbers.contains(bonusNumber))
    }
}
