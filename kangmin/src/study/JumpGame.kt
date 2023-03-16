package study

object JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var dist = 0
        var cur = 0
        while (cur <= dist) {
            // 최대한 뒤로가기
            dist = dist.coerceAtLeast(cur + nums[cur])
            // 목표지점에 도달 가능해지면 true
            if (dist >= nums.size - 1) return true
            // 다음 좌표부터 시작
            cur++
        }
        return false
    }
}

fun main() {

    val list = mutableListOf<Int>()
    for (i in 9997 downTo 0) {
        list.add(i)
    }
    list.add(0)

    val result = JumpGame.canJump(list.toIntArray())
    println(result)
}