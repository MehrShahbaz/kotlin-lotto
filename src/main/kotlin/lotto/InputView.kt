package lotto

object InputView {
    fun readPurchaseAmount(): Int {
        println(PURCHASE_MESSAGE)
        val amount = readln().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Wrong input")
        return amount
    }

    fun readWinningNumbers(): MutableSet<Int> {
        println(WINNING_NUMBERS_MESSAGE)
        val numbers =
            readln().split(", ")
                .map {
                    it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Wrong input")
                }
        return numbers.toMutableSet()
    }

    fun readBonusNumber(): Int {
        println(BONUS_NUMBER_MESSAGE)
        val number = readln().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Wrong input")
        println()
        return number
    }

    private const val PURCHASE_MESSAGE = "Please enter the purchase amount."
    private const val WINNING_NUMBERS_MESSAGE = "Please enter last week’s winning numbers."
    private const val BONUS_NUMBER_MESSAGE = "Please enter the bonus number."
}
