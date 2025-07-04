package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.numbers.sorted()) }
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

    private fun Rank.toText(count: Int): String =
        when (this) {
            Rank.SECOND -> displaySecondRank(this, count)
            else -> "${this.countOfMatch} Matches (${String.format("%,d", this.winningMoney)} KRW) - $count tickets"
        }

    fun displayReturnRate(returnRate: Float) {
        println("Total return rate is $returnRate% (A rate below 1 means a loss).")
    }

    private fun displaySecondRank(
        rank: Rank,
        count: Int,
    ): String {
        val winningMoney = String.format("%,d", rank.winningMoney)
        return "${rank.countOfMatch} Matches + Bonus Ball ($winningMoney KRW) - $count tickets"
    }
}
