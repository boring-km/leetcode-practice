package study

object ReorderList {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun reorderList(head: ListNode?): Unit {

        var copied: ListNode? = head

        var size = 1
        val nodeList = mutableListOf<Int>()
        nodeList.add(copied!!.`val`)

        while (copied?.next != null) {
            size++
            copied = copied.next
            if (copied != null) {
                nodeList.add(copied.`val`)
            }
        }

        recursive(head, 0, 1, 0,  size - 1, nodeList)
    }

    private fun recursive(node: ListNode?, cur: Int, a: Int, i: Int, last: Int, nodeList: MutableList<Int>) {
        if (node?.next != null) {
            if (cur % 2 == 0) {
                node.next!!.`val` = nodeList[last - i]
                recursive(node.next, cur + 1, a, i + 1, last, nodeList)
            } else {
                node.next!!.`val` = nodeList[a]
                recursive(node.next, cur + 1, a + 1, i, last, nodeList)
            }
        } else {
            return
        }
    }
}