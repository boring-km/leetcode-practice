package study

private fun longestPalindrome(s: String): String {

    if (s.length <= 1) {
        return s
    }

    var start = 0
    var end = 0

    for (i in s.indices) {
        val sub1 = s.substring(i - end, i + 1)
        // 팰린드롬 만났다면?
        if (sub1 == sub1.reversed()) {
            start = i - end
            end++
        } else if (i - end > 0) {
            // 지나간 하나 앞에꺼랑 같이 비교하기
            val sub2 = s.substring(i - end - 1, i + 1)
            if (sub2 == sub2.reversed()) {
                start = i - end - 1
                end += 2
            }
        }
    }

    return s.substring(start, start + end)
}

fun main() {
    val result = longestPalindrome("babad")
    print(result)
}
