package study

object ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val arr = IntArray(50)
        arr[1] = 1
        arr[2] = 2

        if (n <= 2) return arr[n]
        else {
            for (i in 3 .. n) {
                arr[i] = arr[i-1] + arr[i-2]
            }
        }

        return arr[n]
    }
}

fun main() {
    val result = ClimbingStairs.climbStairs(3)
    println(result)
}