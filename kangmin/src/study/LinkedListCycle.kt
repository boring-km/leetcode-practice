package study


object LinkedListCycle {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    // Map으로 구현할 때 오답 나오는 경우 있었음
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next!!.next // 2칸씩
            slow = slow!!.next  // 1칸씩
            if (fast == slow) {
                return true
            }
        }
        return false
    }
}

fun main() {
    println(LinkedListCycle.hasCycle(LinkedListCycle.ListNode(0)))
}