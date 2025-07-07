package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EnteredTicketCountTest {
    @Test
    fun `Manual ticket count cannot be less than 0`() {
        assertThrows<IllegalArgumentException> { EnteredTicketCount(-1) }
    }

    @Test
    fun `Manual ticket count must be positive`() {
        assertEquals(EnteredTicketCount(4).count, 4)
    }
}
