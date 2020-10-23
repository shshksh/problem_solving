import collections
from typing import List


class Solution:
    def twoSum(self, nums, index, answer):
        c = nums[index]

        d = collections.defaultdict(int)
        result = []

        for i, v in enumerate(nums):
            if i == index:
                continue
            if v in d:
                arr = sorted([v, d[v], c])
                answer.append(arr)
            d[-c - v] = v

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []

        answer = []
        nums.sort()

        for i in range(len(nums)):
            if i == 0 or nums[i] != nums[i - 1]:
                self.twoSum(nums, i, answer)

        answer.sort()
        unique = []
        for triple in answer:
            if not unique or triple != unique[-1]:
                unique.append(triple)

        return unique
