package study

object MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        // 처음엔 값이 다 똑같지
        var mini = nums[0]
        var maxi = nums[0]
        var answer = nums[0]

        val n = nums.size
        for (i in 1 until n) {

            // nums[i], 현재 최댓값 * nums[i], 현재 최솟값 * nums[i] -> 여기서 가장 최댓값, 최솟값을 알아냄 -> 그리고 거기서 최댓값이 지금까지 최댓값인지
            val tempMaxi = nums[i].coerceAtLeast(maxi * nums[i]).coerceAtLeast(mini * nums[i])
            val tempMini = nums[i].coerceAtMost(maxi * nums[i]).coerceAtMost(mini * nums[i])
            maxi = tempMaxi
            mini = tempMini
            answer = maxi.coerceAtLeast(answer)
        }
        return answer
    }
}

fun main() {
    println(MaximumProductSubarray.maxProduct(intArrayOf(-2, -3, -4)))
}