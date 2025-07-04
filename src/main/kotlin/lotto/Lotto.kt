package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        require(numbers.all { it in MIN..MAX })
        require(numbers.distinct().size == 6)
    }

    companion object {
        const val MIN = 0
        const val MAX = 50
        const val LOTTO_SIZE = 6
    }
}
