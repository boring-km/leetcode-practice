package study

object ReversedLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {

        var answer: ListNode? = null
        var copied = head   // head copy
        while (copied != null) {
            val temp = copied   // 현재 head 복사
            copied = copied.next    // head 포인터 이동 (head 하나씩 줄어들기)
            temp.next = answer    // 이동할 포인터에 현재 head (answer 하나씩 늘어나기)
            answer = temp
        }
        return answer
    }

}