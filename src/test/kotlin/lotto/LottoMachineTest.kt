package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `Purchase amount should be minimum 1_000 and (maximum 20_000 KRW)`() {
        assertThrows<IllegalArgumentException> { LottoMachine(0) }
    }

    @Test
    fun `2Purchase amount should be minimum 1_000 and (maximum 20_000 KRW)`() {
        assertThrows<IllegalArgumentException> { LottoMachine(21000) }
    }
}

