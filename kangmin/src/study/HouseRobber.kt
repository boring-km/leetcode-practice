package study

object HouseRobber {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        if (n == 1) return nums[0]

        nums[1] = nums[0].coerceAtLeast(nums[1])
        for (i in 2 until n) {
            nums[i] = nums[i - 1].coerceAtLeast(nums[i - 2] + nums[i])
        }

        return nums[n - 1]
    }
}