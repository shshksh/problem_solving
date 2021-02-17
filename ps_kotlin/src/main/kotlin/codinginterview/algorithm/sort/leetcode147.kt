package codinginterview.algorithm.sort

fun insertionSortList(head: ListNode?): ListNode? {
    head ?: return null
    return insert(null, head)
}

fun insert(acc: ListNode?, head: ListNode?): ListNode? {
    if (acc == null) {
        val next = head?.next
        head?.next = null
        return insert(head, next)
    } else if (head == null)
        return acc
    else {
        var curr = acc
        var prev: ListNode? = null
        while (curr != null && curr.`val` <= head.`val`) {
            prev = curr
            curr = curr.next
        }
        val next = head.next

        return when {
            prev == null -> {
                head.next = acc
                insert(head, next)
            }
            curr == null -> {
                prev.next = head
                head.next = null
                insert(acc, next)
            }
            else -> {
                prev.next = head
                head.next = curr
                insert(acc, next)
            }
        }
    }
}

fun main() {
    val tmp = ListNode(-1)
    tmp.next = ListNode(5)
    tmp.next?.next = ListNode(3)
    tmp.next?.next?.next = ListNode(4)
    tmp.next?.next?.next?.next = ListNode(0)

    var curr = insertionSortList(tmp)
    while (curr != null) {
        println(curr.`val`)
        curr = curr.next
    }
}