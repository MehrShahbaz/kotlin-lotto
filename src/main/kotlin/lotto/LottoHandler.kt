package lotto

import lotto.view.InputView
import lotto.view.OutputView

object LottoHandler {
    fun start() {
        try {
            val purchaseAmount = processPurchaseAmount()
            val ticketCounter = processTicketCount(purchaseAmount)

            val machine = LottoMachine(ticketCounter)
            machine.tickets.addAll(
                readManualTickets(
                    machine.ticketCounter.enteredTicketCount.count,
                ),
            )
            OutputView.displayTickets(machine.tickets)
            OutputView.displayChange(machine.showChange())

            val winningTicket = readTicket("Please enter last week’s winning numbers.")
            val bonusNumber = readBonusNumbers()
            val winningNumbers = WinningNumbers(winningTicket, bonusNumber)

            val calculator = Calculator(machine.tickets, winningNumbers)

            val returnRate = calculator.calculateReturnRate(machine.ticketCounter.purchaseAmount)
            OutputView.displayWinnings(calculator.results)
            OutputView.displayTotalWinningAmount(calculator.calculateTotalEarnings())
            OutputView.displayReturnRate(returnRate)
        } catch (err: IllegalArgumentException) {
            OutputView.displayError(err.message)
        }
    }

    private fun processPurchaseAmount(): PurchaseAmount {
        repeat(MAX_ATTEMPT) {
            try {
                val purchaseAmount = InputView.readPurchaseAmount()
                return PurchaseAmount(purchaseAmount)
            } catch (err: IllegalArgumentException) {
                OutputView.displayError(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun processTicketCount(purchaseAmount: PurchaseAmount): TicketCounter {
        repeat(MAX_ATTEMPT) {
            try {
                val count = InputView.readManualTicketCount()
                return TicketCounter(purchaseAmount, EnteredTicketCount(count))
            } catch (err: IllegalArgumentException) {
                OutputView.displayError(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun readManualTickets(count: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(count) {
            tickets.add(readTicket("Enter the numbers for manual tickets."))
        }
        return tickets
    }

    private fun readTicket(message: String): Lotto {
        repeat(MAX_ATTEMPT) {
            try {
                val winningNumbers = InputView.readTicket(message).map(LottoNumber::from)
                return Lotto(winningNumbers)
            } catch (err: IllegalArgumentException) {
                OutputView.displayError(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private fun readBonusNumbers(): LottoNumber {
        repeat(MAX_ATTEMPT) {
            try {
                val number = InputView.readBonusNumber()
                return LottoNumber.from(number)
            } catch (err: IllegalArgumentException) {
                OutputView.displayError(err.message)
            }
        }
        throw IllegalArgumentException(MAX_ATTEMPT_MESSAGE)
    }

    private const val MAX_ATTEMPT = 5
    private const val MAX_ATTEMPT_MESSAGE = "Too many attempts"
}
