package study

object InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val temp = intervals.toMutableList()
        temp.add(newInterval)

        val sorted = temp.toTypedArray().sortedArrayWith(Comparator { o1: IntArray, o2: IntArray ->
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

}