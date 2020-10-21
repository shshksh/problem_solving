class Solution:
    def ispalindrome(self, s: str):
        return s == s[::-1]

    def longestPalindrome(self, s: str) -> str:
        for i in range(len(s)):
            for j in range(i + 1):
                if self.ispalindrome(s[j:len(s) - i + j]):
                    return s[j:len(s) - i + j]
