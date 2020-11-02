# Definition for singly-linked list.
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        cursor = head
        prev = None
        while cursor is not None:
            cursor.prev = prev
            prev = cursor
            cursor = cursor.next
        while head is not None:
            if head.val != prev.val:
                return False
            head = head.next
            prev = prev.prev
        return True


# Solution for Runner
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        fast = slow = head
        rev = None

        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        if fast:
            slow = slow.next

        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
        return not rev

