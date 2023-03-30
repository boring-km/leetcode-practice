package study

object LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {

        val sorted = nums.toSortedSet().toList()
        val n = sorted.size
        if (n <= 1) return n

        var maxi = 1
        var previous = sorted[0]
        var cur = 1

        for (i in 1 until n) {
            if (previous + 1 == sorted[i]) {
                cur++
                maxi = maxi.coerceAtLeast(cur)
            } else {
                cur = 1
            }
            previous = sorted[i]
        }

        return maxi
    }
}

fun main() {
    val result = LongestConsecutiveSequence.longestConsecutive(intArrayOf(1, 2, 0, 1))
    println(result)
}