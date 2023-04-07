package study

object Number1Bits {
    fun hammingWeight(n: Int): Int {
        return Integer.bitCount(n)
    }
}

fun main() {
    println(Number1Bits.hammingWeight("10000000000000000000000000000000".toLong(2).toInt()))
    println(Number1Bits.hammingWeight("11111111111111111111111111111101".toLong(2).toInt()))
    println(Number1Bits.hammingWeight("11111111111111111111111111111111".toLong(2).toInt()))
}