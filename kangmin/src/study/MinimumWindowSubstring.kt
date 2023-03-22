package study

import kotlin.collections.HashMap

object MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {

        val target = t.toCharArray()
        val n = s.length
        var count = target.size
        var answerMove = n+1

        var first = 0
        var left = 0
        var right = 0

        if (n <= 0 || count <= 0) return ""

        val map = HashMap<Char, Int>()
        for (item in target) {
            map[item] = map.getOrDefault(item, 0) + 1
        }

        while (right < n) {
            if (map.containsKey(s[right])) {
                if (map[s[right]]!! > 0) {
                    count-- // 포함되는 값을 찾았으면 -1
                }
                map.compute(s[right]) { _, num: Int? -> num?.minus(1) } // 음수로 갈 수도 있음
            }
            right++ // t 값을 전부 포함할 때까지 오른쪽으로 포인터 이동

            while (count == 0) {    // 다 찾았다면
                if (right - left < answerMove) {    // 이동거리 최솟값 구하기
                    answerMove = right - left
                    first = left    // 시작 포인터 당기기
                }
                if (map.containsKey(s[left])) {
                    if (map[s[left]]!! == 0) {
                        count++
                    }
                    map.compute(s[left]) { _, num -> num?.plus(1) }
                }
                left++
            }
        }

        return if (answerMove == n+1) ""
        else s.substring(first, first + answerMove)
    }
}

fun main() {
    val result = MinimumWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae")
    println(result)
}