package study

object MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        val sorted = intervals.sortedArrayWith(Comparator { o1: IntArray, o2: IntArray ->
            compareValues(o1[0], o2[0])
        })

        val array = BooleanArray(10001)
        val map = HashMap<Int, Int>()

        for (interval in sorted) {
            val start = interval[0]
            val end = interval[1]

            if (start == end && !map.containsKey(start)) map[start] = start
            else {
                for (i in start until end) {
                    map[i] = i + 1
                }
            }
        }

        val result = mutableListOf<IntArray>()
        var i = 0
        while (i < array.size) {
            if (map.containsKey(i)) {
                var temp = i
                while (map.containsKey(temp) && map[temp] == temp + 1) {
                    temp++
                }
                result.add(intArrayOf(i, temp))
                i = temp
            }
            i++
        }

        return result.toTypedArray()
    }
}

fun main() {
//    var result =
//        MergeIntervals.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
//    println()
//    result.forEach {
//        it.forEach { num ->
//            print(("$num "))
//        }
//        println()
//    }
//    println("===")
//    result =
//        MergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(5, 5), intArrayOf(6, 7), intArrayOf(7, 7)))
//    println()
//    result.forEach {
//        it.forEach { num ->
//            print(("$num "))
//        }
//        println()
//    }
//    println("===")
//    result =
//        MergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 0)))
//    println()
//    result.forEach {
//        it.forEach { num ->
//            print(("$num "))
//        }
//        println()
//    }
//    println("===")
//    result =
//        MergeIntervals.merge(
//            arrayOf(
//                intArrayOf(2, 3),
//                intArrayOf(5, 5),
//                intArrayOf(2, 2),
//                intArrayOf(3, 4),
//                intArrayOf(3, 4)
//            )
//        )
//    println()
//    result.forEach {
//        it.forEach { num ->
//            print(("$num "))
//        }
//        println()
//    }
//    println("===")
    var result =
        MergeIntervals.merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(0, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 6),
                intArrayOf(4, 5),
                intArrayOf(5, 5),
                intArrayOf(0, 2),
                intArrayOf(3, 3)
            )
        )
    println()
    result.forEach {
        it.forEach { num ->
            print(("$num "))
        }
        println()
    }
}