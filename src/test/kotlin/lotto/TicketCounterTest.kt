package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketCounterTest {
    @Test
    fun `Manual ticket count should be less than generated tickets`() {
        assertThrows<IllegalArgumentException> { TicketCounter(3, 4) }
    }

    @Test
    fun `Manual ticket count must be positive`() {
        assertThrows<IllegalArgumentException> { TicketCounter(-1, 3) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `Manual ticket count should be less than generated tickets`(number: Int) {
        assertEquals(
            TicketCounter(3, number).enteredTickets,
            number,
        )
    }
}
