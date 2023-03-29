package study

object ValidPalindrome {
    fun isPalindrome(s: String): Boolean {

        val list = mutableListOf<Char>()

        for (ch in s) {
            val code = ch.toInt()
            if (code in 65 until 91) {
                list.add((code + 32).toChar())
            } else if (code in 97 until 123 || code in 48 .. 57) {
                list.add(ch)
            }
        }
        val reversed = list.reversed()

        for (i in list.indices) {
            if (reversed[i] != list[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(ValidPalindrome.isPalindrome("0P"))

    println('9'.code)
}