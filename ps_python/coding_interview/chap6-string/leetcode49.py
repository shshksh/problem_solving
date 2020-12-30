import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def count(word: str):
            arr = [0 for _ in range(26)]
            for char in word:
                arr[ord(char) - 97] += 1
            return tuple(arr)

        d = collections.defaultdict(list)
        for word in strs:
            d[count(word)].append(word)

        return [d[key] for key in d]


print(Solution().groupAnagrams(strs=["eat", "tea", "tan", "ate", "nat", "bat"]))
