package study
private fun lengthOfLongestSubstring(s: String): Int {

    var maxi = 0
    var count = 0
    val n = s.length
    while (n - count > maxi) {
        var cur = 0

        val arr = s.substring(count).toCharArray()

        var record = BooleanArray(1000)

        for (c in arr) {
            if (!record[c.code]) {  // leetcode 에선 toInt()
                cur++
                maxi = maxi.coerceAtLeast(cur)
            } else {
                cur = 1
                record = BooleanArray(1000)
            }
            record[c.code] = true   // leetcode 에선 toInt()
        }

        count++
    }

    return maxi
}

fun main() {
    var result = lengthOfLongestSubstring("dvdf")
    print(result)
    result = lengthOfLongestSubstring(" ")
    print(result)
}