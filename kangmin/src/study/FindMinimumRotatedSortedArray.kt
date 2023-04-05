package study

object FindMinimumRotatedSortedArray {
    fun findMin(nums: IntArray): Int {

        var count = 0
        var maxi = nums[0]
        var answer = nums[0]
        val n = nums.size

        if (n == 1) return maxi

        for (i in 1 until n) {
            answer = answer.coerceAtMost(nums[i])
            if (maxi < nums[i]) {
                maxi = nums[i]
            } else {
                return nums[i]
            }
        }

        return answer
    }
}