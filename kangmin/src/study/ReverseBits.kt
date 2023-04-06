package study

object ReverseBits {
    fun reverseBits(n: Int): Int {
        var result = 0
        var m = n
        for (i in 0..31) {
            result += m and 1
            m = m ushr 1
            if (i < 31)
                result = result shl 1
        }
        return result
    }
}

fun main() {
    println(ReverseBits.reverseBits(43261596))
}