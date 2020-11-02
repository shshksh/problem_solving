from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        d = {}
        n = len(nums) - 1

        for i, v in enumerate(nums):
            d[(0, i)] = d.setdefault((0, i - 1), 1) * v
            d[(n - i, n)] = d.setdefault((n - i + 1, n), 1) * nums[n - i]

        return [d[0, i-1] * d[i+1, n] for i in range(n + 1)]
