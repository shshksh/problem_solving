from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        merge = []
        for list in lists:
            while list is not None:
                merge.append(list.val)
                list = list.next

        merge.sort()
        head = ListNode()
        curr = head
        for value in merge:
            curr.next = ListNode(value)
            curr = curr.next

        return head.next
