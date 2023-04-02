package study


private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val copy: ListNode?
    val target = findLength(head) - n
    if (n == 1 && target == 0) {
        return null
    } else if (target == 0) {
        return head?.next
    } else {
        copy = ListNode(head?.`val`!!)
    }
    recursive(copy, head, 1, target, target + n)
    return copy
}

// target을 찾을 때까지 재귀
private fun recursive(curNode: ListNode?, original: ListNode?, count: Int, target: Int, length: Int) {
    if (count == length) {
        return
    }
    if (count < target || target < count) {
        val newNodeValue = original?.next?.`val`
        curNode?.next = ListNode(newNodeValue!!)
        recursive(curNode?.next, original.next, count + 1, target, length)
    } else {
        // target을 찾으면 그냥 pass -> copy하지 않음
        recursive(curNode, original?.next, count + 1, target, length)
    }
}

// 길이/깊이 구하기
private fun findLength(head: ListNode?): Int {
    var temp = head
    var length = 0
    while (temp != null) {
        length++
        temp = temp.next
    }
    return length
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    var result = removeNthFromEnd(head, 2)

    while (result?.`val` != null) {
        print("${result.`val`} ")
        result = result.next
    }
}