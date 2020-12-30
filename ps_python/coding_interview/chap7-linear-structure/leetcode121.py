from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0

        min_price = prices[0]
        best = 0
        for i, v in enumerate(prices):
            min_price = min(min_price, v)
            if i > 0 and v > prices[i - 1]:
                best = max(best, v - min_price)

        return best
