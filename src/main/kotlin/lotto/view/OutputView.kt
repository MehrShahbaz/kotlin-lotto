package lotto.view

import lotto.Lotto
import lotto.LottoNumber
import lotto.Rank
import lotto.TicketCounter

object OutputView {
    fun displayTickets(
        tickets: List<Lotto>,
        ticketCounter: TicketCounter,
    ) {
        printTicketCount(ticketCounter)
        val textByTicket =
            tickets
                .map(OutputView::sortedLottoTicket)
                .joinToString("\n")

        println(textByTicket)
        println()
    }

    fun displayChange(change: Int) {
        println("Your change is $change KRW.")
        println()
    }

    fun displayTotalWinningAmount(totalAmount: Float) {
        println("Total Earnings $totalAmount KRW.")
    }

    data class WinningResults(val results: Map<Rank, Int>) {
        operator fun get(rank: Rank): Int = results.getOrDefault(rank, 0)
    }

    fun displayWinnings(results: MutableMap<Rank, Int>) {
        val winningResults = WinningResults(results)
        val textByRank =
            Rank
                .entries.filterNot { it == Rank.MISS }
                .associateWith { it.toText(winningResults[it]) }
                .values.joinToString("\n")
        println(
            """
                |Winning Statistics
                |------------------
                |$textByRank
            """.trimMargin(),
        )
    }

    fun displayReturnRate(returnRate: Float) {
        println("Total return rate is ${"%.2f".format(returnRate)} (A rate below 1 means a loss).")
    }

    fun displayError(errorMessage: String?) {
        println("[Error]::${errorMessage ?: ""}")
    }

    private fun sortedLottoTicket(ticket: Lotto): List<Int> {
        return ticket.numbers
            .map(LottoNumber::value)
            .sorted()
    }

    private fun Rank.toText(count: Int): String =
        when (this) {
            Rank.SECOND -> displaySecondRank(this, count)
            else -> "${this.countOfMatch} Matches (${String.format("%,d", this.winningMoney)} KRW) - $count tickets"
        }

    private fun displaySecondRank(
        rank: Rank,
        count: Int,
    ): String {
        val winningMoney = String.format("%,d", rank.winningMoney)
        return "${rank.countOfMatch} Matches + Bonus Ball ($winningMoney KRW) - $count tickets"
    }

    private fun printTicketCount(ticketCounter: TicketCounter) {
        println(
            "\nPurchased ${ticketCounter.enteredTicketCount.count} manual and ${ticketCounter.generatedTicketCount} automatic tickets.",
        )
    }
}
