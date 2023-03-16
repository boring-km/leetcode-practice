package study

object MergeTwoSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        val a = list1?.`val`
        val b = list2?.`val`

        if (a == null) {
            if (b == null) return null
            return list2
        } else {
            if (b == null) return list1
            return recursive(null, list1, list2)
        }
    }

    private fun recursive(current: ListNode?, a: ListNode?, b: ListNode?): ListNode? {
        if (a?.`val` != null) {
            if (b?.`val` != null) {
                if (a.`val` <= b.`val`) {
                    val temp = getTemp(a, current)
                    return recursive(temp, a.next, b)
                } else {
                    val temp = getTemp(b, current)
                    return recursive(temp, a, b.next)
                }
            } else {
                val temp = getTemp(a, current)
                return recursive(temp, a.next, null)
            }
        } else {
            if (b?.`val` != null) {
                val temp = getTemp(b, current)
                return recursive(temp, null, b.next)
            }
        }
        return current
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
    val a = MergeTwoSortedLists.ListNode(1)
    a.next = MergeTwoSortedLists.ListNode(2)
    a.next!!.next = MergeTwoSortedLists.ListNode(4)

    val b = MergeTwoSortedLists.ListNode(1)
    b.next = MergeTwoSortedLists.ListNode(3)
    b.next!!.next = MergeTwoSortedLists.ListNode(4)

    val result = MergeTwoSortedLists.mergeTwoLists(a, b)
    print(result?.`val`)
}