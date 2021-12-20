package algorithm.sort

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun sortList(head: ListNode?): ListNode? {
    val arrayList = mutableListOf<Int>()

    var curr = head
    while (curr != null) {
        arrayList.add(curr.`val`)
        curr = curr.next
    }

    arrayList.sortDescending()
    var newHead: ListNode? = null

    for (`val` in arrayList) {
        val tmp = ListNode(`val`)
        tmp.next = newHead
        newHead = tmp
    }

    return newHead
}
