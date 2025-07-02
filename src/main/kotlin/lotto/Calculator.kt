package lotto

import kotlin.collections.emptyMap

class Calculator(
    val tickets: List<Lotto>,
    val winningNumbers: WinningNumbers,
    var results: MutableMap<Rank, Int> = emptyMap<Rank,Int>().toMutableMap()
) {
    init {
        results = emptyMap<Rank,Int>().toMutableMap()
    }

    fun start() {
        tickets.forEach {
            val count = findMatches(it, winningNumbers.winningNumbers)
            val rank = Rank.valueOf(
                count,
                bonusNumberPresent(it, winningNumbers.bonusNumber)
            )
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
    }

    private fun findMatches(ticket: Lotto, winningTicket: Lotto): Int {
        var count = 0
        ticket.numbers.forEach { count += if (winningTicket.numbers.contains(it)) 1 else 0 }
        return count
    }

    private fun bonusNumberPresent(ticket: Lotto, bonusNumber: Int): Boolean {
        return ticket.numbers.contains(bonusNumber)
    }
}