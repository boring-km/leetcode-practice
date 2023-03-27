package study

object BestTimeBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {

        val n = prices.size
        var answer = 0
        var min = prices[0]

        // 카데인 알고리즘
        for (i in 1 until n) {
            val temp = prices[i] - min
            answer = answer.coerceAtLeast(temp)
            min = min.coerceAtMost(prices[i])
        }

        return answer
    }
}

fun main() {
    val result = BestTimeBuyAndSellStock.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    println(result)
}