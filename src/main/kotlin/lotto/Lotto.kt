package lotto

class Lotto(var numbers: MutableSet<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            throw IllegalArgumentException()
        }
        require(numbers.all { it in MIN..MAX }) {
            throw IllegalArgumentException()
        }
//        require(numbers.distinct().size == 6) {
//            throw IllegalArgumentException()
//        }
    }

    companion object {
        private const val MIN = 0
        private const val MAX = 50
        private const val LOTTO_SIZE = 6
    }
}