package lotto

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_SIZE)
        require(numbers.distinct().size == LOTTO_SIZE)
    }

    fun sortedList(): List<Int> {
        return numbers.map(LottoNumber::value).sorted()
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
