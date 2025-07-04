package lotto

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun `Count number of matches between Lotto ticket and winning numbers`() {
        val lotto = Lotto(createListLottoNumber(listOf(3, 8, 27, 30, 35, 44)))
        val numbers = Lotto(createListLottoNumber(listOf(3, 8, 27, 4, 5, 6)))
        val winningNumbers = WinningNumbers(numbers, LottoNumber.from(7))

        val calculator = Calculator(mutableListOf<Lotto>(lotto), winningNumbers)
        assertEquals(calculator.results.contains(Rank.FIFTH), true)
    }

    @Test
    fun `test return rate`() {
        val tickets =
            mutableListOf(
                // FIRST
                Lotto(createListLottoNumber(listOf(3, 8, 27, 4, 5, 6))),
                // THIRD
                Lotto(createListLottoNumber(listOf(3, 8, 27, 4, 5, 43))),
                Lotto(createListLottoNumber(listOf(7, 11, 16, 35, 36, 44))),
                Lotto(createListLottoNumber(listOf(1, 8, 11, 31, 41, 42))),
                Lotto(createListLottoNumber(listOf(13, 14, 16, 38, 42, 45))),
            )
        val numbers = Lotto(createListLottoNumber(listOf(3, 8, 27, 4, 5, 6)))
        val winningNumbers = WinningNumbers(numbers, LottoNumber.from(7))
        val calculator = Calculator(tickets, winningNumbers)
        assertEquals(calculator.calculateReturnRate(5000), 400300f)
    }

    fun createListLottoNumber(numbers: List<Int>): List<LottoNumber> = numbers.map { it -> LottoNumber.from(it) }
}
