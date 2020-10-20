import re
from typing import List
import collections


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        word, words = '', []
        for char in paragraph.lower()+' ':
            if char.isalnum():
                word += char
            else:
                if len(word) != 0 and word not in banned:
                    words.append(word)
                    word = ''
                else:
                    word = ''

        counter = collections.Counter(words)

        return counter.most_common(1)[0][0]
