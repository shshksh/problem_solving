class Solution:
    def isValid(self, s: str) -> bool:
        d = {'(': ')', '{': '}', '[': ']'}
        opening = d.keys()
        stack = []
        for c in s:
            if c in opening:
                stack.append(c)
            else:
                if not stack or d[stack[len(stack)-1]] == c:
                    stack.pop()
                else:
                    return False
        return not stack
