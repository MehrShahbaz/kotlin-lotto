package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EnteredTicketCountTest {
    @Test
    fun `Manual ticket count cannot be less than 0`() {
        assertThrows<IllegalArgumentException> { EnteredTicketCount(-1) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 4])
    fun `Generates correct number of tickets as a list`(count: Int) {
        assertEquals(EnteredTicketCount(count).count, count)
    }
}
