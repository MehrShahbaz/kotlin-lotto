package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.Assertions.assertEquals

class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 21000])
    fun `Purchase amount should be minimum 1_000 and (maximum 20_000 KRW)`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoMachine(number) }
    }

    @Test
    fun `Change is calculated for the User`() {
        val machine = LottoMachine(1234)
        assertEquals(machine.showChange(), 234)
    }
}

