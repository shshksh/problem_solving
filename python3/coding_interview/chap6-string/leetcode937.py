from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters: List[str] = []
        digits: List[str] = []

        for log in logs:
            element = log.split(' ')
            if element[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)

        letters.sort(key=(lambda x: x.split(' ')[1:] + [x]))
        return letters + digits
