package lotto

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "List should have exactly 6 numbers" }
        require(numbers.distinct().size == LOTTO_SIZE) { "All the numbers in the list must be unique" }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
