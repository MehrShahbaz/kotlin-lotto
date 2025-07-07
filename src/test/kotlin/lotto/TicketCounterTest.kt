package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketCounterTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 4, 9])
    fun `Entered Ticket count is less than equal too Purchasable tickets`(number: Int) {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(number)
        assertEquals(
            TicketCounter(purchaseAmount, enteredTicketCount).purchaseAmount,
            purchaseAmount,
        )
    }

    @Test
    fun `Entered Ticket count should be less than Purchasable tickets`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(10)
        assertThrows<IllegalArgumentException> {
            TicketCounter(purchaseAmount, enteredTicketCount).purchaseAmount
        }
    }

    @Test
    fun `Generated ticket count is correct`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(4)
        assertEquals(
            TicketCounter(purchaseAmount, enteredTicketCount).generatedTicketCount,
            5,
        )
    }
}
