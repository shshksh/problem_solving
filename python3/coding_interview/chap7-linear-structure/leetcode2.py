class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = l1
        while l1 or l2:
            if l2:
                l1.val += l2.val
            if l1.val >= 10:
                l1.val -= 10
                if not l1.next:
                    l1.next = ListNode()
                l1.next.val += 1

            if not l1.next and l2 and l2.next:
                l1.next = ListNode()
            l1 = l1.next
            if l2:
                l2 = l2.next

        return head
