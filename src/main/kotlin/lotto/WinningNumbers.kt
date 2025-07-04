package lotto

data class WinningNumbers(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!winningNumbers.numbers.contains(bonusNumber))
    }
}
