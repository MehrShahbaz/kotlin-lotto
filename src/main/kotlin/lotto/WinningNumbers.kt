package lotto

data class WinningNumbers(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!winningNumbers.numbers.contains(bonusNumber)) { ERROR_MESSAGE }
    }

    companion object {
        private const val ERROR_MESSAGE =
            "Bonus Number should not be present in the Winning Numbers"
    }
}
