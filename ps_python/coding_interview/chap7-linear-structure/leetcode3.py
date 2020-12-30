class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length, st = 0, 0
        for i in range(len(s)):
            if s[i] in s[st:i]:
                st = st + s[st:i].index(s[i]) + 1
            else:
                length = max(length, len(s[st:i+1]))
        return length