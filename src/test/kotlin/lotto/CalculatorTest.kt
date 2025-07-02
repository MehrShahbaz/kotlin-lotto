package lotto

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun `Count number of matches between Lotto ticket and winning numbers`() {
        val lotto = Lotto(mutableSetOf(3, 8, 27, 30, 35, 44))
        val numbers = Lotto(mutableSetOf(3,8,27,4,5,6))
        val winningNumbers = WinningNumbers(numbers, 7)

        val calculator = Calculator(mutableListOf<Lotto>(lotto), winningNumbers)
        calculator.start()
        assertEquals(calculator.results.contains(Rank.FIFTH), true)
    }
}