class MyCircularDeque:
    class ListNode:
        def __init__(self, val=0, right=None, left=None):
            self.val = val
            self.right = right
            self.left = left

    def __init__(self, k: int):
        self.max_size = k
        self.size = 0
        self.head: MyCircularDeque.ListNode = None
        self.tail: MyCircularDeque.ListNode = None

    def insertFront(self, value: int) -> bool:
        if self.isFull():
            return False
        if self.head is None:
            self.head = MyCircularDeque.ListNode(value)
            self.tail = self.head
        else:
            added = MyCircularDeque.ListNode(value, right=self.head)
            self.head.left = added
            self.head = added
        self.size += 1
        return True

    def insertLast(self, value: int) -> bool:
        if self.isFull():
            return False
        if self.tail is None:
            self.tail = MyCircularDeque.ListNode(value)
            self.head = self.tail
        else:
            added = MyCircularDeque.ListNode(value, left=self.tail)
            self.tail.right = added
            self.tail = added
        self.size += 1
        return True

    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False
        if self.head == self.tail:
            self.head, self.tail = None, None 
        else:
            self.head, next = None, self.head.right
            self.head = next
            if self.head is not None:
                self.head.left = None

        self.size -= 1
        return True

    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False

        if self.head == self.tail:
            self.head, self.tail = None, None
        else:
            self.tail, prev = None, self.tail.left
            self.tail = prev
            if self.tail is not None:
                self.tail.right = None

        self.size -= 1
        return True

    def getFront(self) -> int:
        if self.isEmpty():
            return -1
        return self.head.val

    def getRear(self) -> int:
        if self.isEmpty():
            return -1
        return self.tail.val

    def isEmpty(self) -> bool:
        return self.head is None

    def isFull(self) -> bool:
        return self.size == self.max_size
