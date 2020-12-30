class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        i = 1
        tmp, prev, curr = None, None, head

        while i <= n:

            if i == m:
                start = curr
                tmp = prev
                prev = curr
                curr = curr.next
            elif m < i <= n:
                nextNode = curr.next
                curr.next = prev
                prev = curr
                curr = nextNode
            else:
                prev = curr
                curr = curr.next
            i += 1

        start.next = curr
        if tmp:
            tmp.next = prev
        else:
            head = prev

        return head
