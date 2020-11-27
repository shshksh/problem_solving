class MyHashMap:

    def __init__(self):
        self.ht = [None for _ in range(1000001)]

    def put(self, key: int, value: int) -> None:
        h = key % 1000001
        for i in range(h, 1000001):
            if self.ht[i] is None:
                self.ht[i] = (key, value)
                return
            elif self.ht[i][0] == key:
                self.ht[i] = (key, value)
                return

    def get(self, key: int) -> int:
        h = key % 1000001
        for i in range(h, 1000001):
            if self.ht[i] is not None:
                if self.ht[i][0] == key:
                    return self.ht[i][1]
            else:
                return -1

    def remove(self, key: int) -> None:
        h = key % 1000001
        for i in range(h, 1000001):
            if self.ht[i] is not None:
                if self.ht[i][0] == key:
                    self.ht[i] = None
                    return
            else:
                return
