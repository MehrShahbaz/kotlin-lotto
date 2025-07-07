package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {
    @Test
    fun `Change is calculated for the User`() {
        val purchaseAmount = PurchaseAmount(9876)
        val enteredTicketCount = EnteredTicketCount(0)

        val ticketCounter = TicketCounter(purchaseAmount, enteredTicketCount)
        val machine = LottoMachine(ticketCounter)
        assertEquals(machine.showChange(), 876)
    }

    @ParameterizedTest
    @ValueSource(ints = [20_000])
    fun `Generates correct number of tickets as a list`(amount: Int) {
        val purchaseAmount = PurchaseAmount(amount)
        val enteredTicketCount = EnteredTicketCount(0)

        val ticketCounter = TicketCounter(purchaseAmount, enteredTicketCount)
        val machine = LottoMachine(ticketCounter)

        assertEquals(machine.tickets.size, amount / LottoMachine.TICKET_PRICE)
    }
}
