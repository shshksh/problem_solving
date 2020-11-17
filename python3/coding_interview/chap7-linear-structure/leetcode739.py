from typing import List


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        result = [0 for _ in range(len(T))]
        for i, temp in enumerate(T):
            if stack and stack[-1][1] < temp:
                while stack and stack[-1][1] < temp:
                    day = stack[-1][0]
                    result[day] = i - day
                    stack.pop()
            stack.append((i, temp))
        return result
