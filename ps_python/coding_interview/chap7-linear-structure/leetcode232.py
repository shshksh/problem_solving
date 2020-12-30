class MyQueue:

    def __init__(self):
        self.q = []
        self.tmp = []

    def push(self, x: int) -> None:
        while self.q:
            self.tmp.append(self.q.pop())
        self.q.append(x)
        while self.tmp:
            self.q.append(self.tmp.pop())

    def pop(self) -> int:
        return self.q.pop()

    def peek(self) -> int:
        return self.q[-1]

    def empty(self) -> bool:
        return len(self.q) == 0
