package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.numbers.joinToString(prefix = "[", postfix = "]")) }
        println()
    }

    fun displayWinnings(results: MutableMap<Rank, Int>) {
        println("Winning Statistics\n------------------")
        Rank.entries.reversed().forEach {
            if(it == Rank.MISS)
                return@forEach
            val count = results.getOrDefault(it,0)
            if(it == Rank.SECOND) {
                println("${it.countOfMatch} Matches + Bonus Ball (${String.format("%,d", it.winningMoney)} KRW) - $count tickets")
                return@forEach
            }
            println("${it.countOfMatch} Matches (${String.format("%,d", it.winningMoney)} KRW) - $count tickets")
        }
    }

    fun displayReturnRate(returnRate: Float) {
        println("Total return rate is $returnRate (A rate below 1 means a loss)")
    }
}