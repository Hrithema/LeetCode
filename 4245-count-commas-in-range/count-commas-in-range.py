class Solution:
    def countCommas(self, n: int) -> int:
        if n > 999 and n < 999999:
            return n - 999
        return 0