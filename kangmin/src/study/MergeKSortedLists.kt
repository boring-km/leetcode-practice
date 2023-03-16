package study

object MergeKSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return recursive(null, lists)
    }

    private fun recursive(current: ListNode?, lists: Array<ListNode?>): ListNode? {

        var minValue = 10000
        var index = -1

        for (i in lists.indices) {
            val temp = lists[i]?.`val`
            if (temp != null && temp < minValue) {
                index = i
                minValue = temp
            }
        }

        if (index == -1) {
            return current
        }

        val node = lists[index]!!
        val next = getTemp(node, current)
        lists[index] = lists[index]!!.next
        return recursive(next, lists)
    }

    private fun getTemp(
        b: ListNode,
        current: ListNode?
    ): ListNode {
        val temp = ListNode(b.`val`)

        if (current != null) {
            addLast(current, temp)
            return current
        }
        return temp
    }

    private fun addLast(cur: ListNode?, last: ListNode) {
        if (cur?.next != null) {
            addLast(cur.next, last)
        } else {
            cur?.next = last
        }
    }
}

fun main() {

    val first = MergeKSortedLists.ListNode(1)
    first.next = MergeKSortedLists.ListNode(4)
    first.next!!.next = MergeKSortedLists.ListNode(5)

    val second = MergeKSortedLists.ListNode(1)
    second.next = MergeKSortedLists.ListNode(3)
    second.next!!.next = MergeKSortedLists.ListNode(4)

    val third = MergeKSortedLists.ListNode(2)
    third.next = MergeKSortedLists.ListNode(6)

    val result = MergeKSortedLists.mergeKLists(arrayOf(
        first, second, third
    ))
    println(result?.`val`)
}