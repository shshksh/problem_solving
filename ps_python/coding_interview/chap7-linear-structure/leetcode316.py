import collections


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        table = []
        for c in s:
            if c in table:
                index = table.index(c)
                fst = table[:]
                table.append(c)
                scd = table[:index] + table[index+1:]
                if fst < scd:
                    table = fst
                else:
                    table = scd
            else:
                table.append(c)
        return "".join(table)


# Solution 1: recursion
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        for char in sorted(set(s)):
            suffix = s[s.index(char):]
            if set(s) == set(suffix):
                return char + self.removeDuplicateLetters(suffix.replace(char, ''))
            return ''

# Solution 2: stack
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        counter, seen, stack = collections.Counter(s), set(), []

        for char in s:
            counter[char] -= 1
            if char in seen:
                continue
            while stack and char < stack[-1] and counter[stack[-1]] > 0:
                seen.remove(stack.pop())
            stack.append(char)
            seen.append(char)

        return ''.join(stack)

