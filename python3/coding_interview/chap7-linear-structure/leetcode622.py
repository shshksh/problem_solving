class MyCircularQueue:

    def __init__(self, k: int):
        self.q = [0 for _ in range(k + 1)]
        self.front = 0
        self.rear = 0

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False
        self.q[self.rear] = value
        self.rear = (self.rear + 1) % len(self.q)
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        self.front = (self.front+1) % len(self.q)
        return True

    def Front(self) -> int:
        if not self.isEmpty():
            return self.q[self.front]
        return -1

    def Rear(self) -> int:
        if not self.isEmpty():
            return self.q[self.rear - 1]
        return -1

    def isEmpty(self) -> bool:
        return self.front == self.rear

    def isFull(self) -> bool:
        return (self.rear + 1) % len(self.q) == self.front
