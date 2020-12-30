import collections


class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        counter = collections.Counter(S)
        s = 0
        for j in J:
            s += counter[j]
        return s

