package study

// 재귀로 풀었더니 시간초과 남
object DecodeWays {
    fun numDecodings(s: String): Int {

        val dp = IntArray(s.length)

        dp[0] = if (s[0] == '0') 0 else 1

        for (i in 1 until s.length) {
            val single = s[i] - '0' // 쉽게 int type 으로 바꾸기
            val double = (s[i-1] - '0') * 10 + single

            if (single != 0) {
                dp[i] += dp[i-1]    // 0이 아닌 한자릿 수면 이전 횟수만큼 경우의 수 발생
            }

            if (double in 10..26) { // 두자릿 수라면 2회 전 횟수만큼 경우의 수 발생
                dp[i] += if (i >= 2) dp[i-2] else 1 // 여기서 한자릿수의 경우에서 추가되는 케이스가 있어서 숫자가 늘어날듯
            }
        }

        return dp[s.length - 1]
    }
}

fun main() {
    println(DecodeWays.numDecodings("11106"))
    println(DecodeWays.numDecodings("226"))
    println(DecodeWays.numDecodings("111111111111111111111111111111111111111111111"))
}