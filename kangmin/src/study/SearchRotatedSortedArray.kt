package study

fun search(nums: IntArray, target: Int): Int {

    val n = nums.size

    if (target < nums[n-1]) {
        val first = nums[n-1]
        for (i in n-2 downTo 0) {
            if (first < nums[i]) break
            if (nums[i] == target) {
                return i
            }
        }
    } else if (nums[n-1] < target) {
        val first = nums[0]
        for (i in 0 .. n-2) {
            if (nums[i] < first) break
            if (nums[i] == target) {
                return i
            }
        }
    } else {
        return n-1
    }

    return -1
}

fun main() {
    val result = search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)
    println(result)
}