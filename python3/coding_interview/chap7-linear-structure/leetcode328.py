class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        odd, even, scd = head, head.next, head.next
        while odd.next and even.next:
            if odd.next.next:
                odd.next = odd.next.next
                odd = odd.next
            if even.next:
                even.next = even.next.next
                even = even.next

        odd.next = scd

        return head


head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)

swap = Solution().oddEvenList(head)
while swap:
    print(swap.val)
    swap = swap.next
