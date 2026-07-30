class Solution:
    def minimumPushes(self, word: str) -> int:
        n = len(word)
        tap = 0
        for i in range(n):
            tap += (i // 8) + 1
        return tap    