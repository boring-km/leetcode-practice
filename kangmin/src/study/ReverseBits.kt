package study

object ReverseBits {
    fun reverseBits(n: Int): Int {
        return Integer.reverse(n)
    }
}

fun main() {
    println(ReverseBits.reverseBits(43261596))
}