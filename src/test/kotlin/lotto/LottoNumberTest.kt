package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-5, 0, 51])
    fun `Numbers should be between 0 and 50`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }
}
