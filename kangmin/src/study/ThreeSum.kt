package study

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val n = nums.size

    for (a in 0 until n - 2) {
        if (a > 0 && nums[a] == nums[a - 1]) continue // 이전 값과 중복이면 패스

        var left = a + 1
        var right = n - 1

        while (left - right < 0) {
            val sum = nums[left] + nums[right] + nums[a]

            if (sum == 0) { // 답을 찾았다면
                result.add(listOf(nums[a], nums[left], nums[right]))
                left++
                right--
                // 이전 값과 같고 여전히 움직일 가능성이 있다면 움직이기 (정답에 추가하지는 않음)
                while (nums[left] == nums[left - 1] && left - right < 0) left++
                while (nums[right] == nums[right + 1] && left - right < 0) right--
            } else if (sum > 0) {   // 합이 더 크다면 (큰 쪽에서 줄이기)
                right--
            } else {    // 합이 더 작다면 (작은 쪽에서 늘리기)
                left++
            }
        }

    }

    return result
}

fun main() {
    val result = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    result.forEach {
        for (item in it) {
            print("$item ")
        }
        println()
    }
}