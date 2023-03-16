package study

private fun twoSum(nums: IntArray, target: Int): IntArray {

    val n = nums.size

    for (i in 0 until n - 1) {
        for (j in i+1 until n) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

fun main() {
    var result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    result.forEach { print("$it ") }
    result = twoSum(intArrayOf(2, 7, 11, 15), 13)
    result.forEach { print("$it ") }
}