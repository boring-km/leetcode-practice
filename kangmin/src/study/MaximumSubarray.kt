package study

object MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {

        var last = 0
        var maxi = Int.MIN_VALUE

        for (num in nums) {
            last = (last + num).coerceAtLeast(num)
            maxi = last.coerceAtLeast(maxi)
        }

        return maxi
    }
}

fun main() {
    val result = MaximumSubarray.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println(result)
}
