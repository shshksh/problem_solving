class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        curr, prev = head, None
        while curr is not None:
            if prev:
                if curr.next:
                    prev.next = curr.next
            elif curr.next:
                head = curr.next
            if curr.next:
                tmp = curr.next
                curr.next = curr.next.next
                tmp.next = curr

            prev = curr
            curr = curr.next

        return head
