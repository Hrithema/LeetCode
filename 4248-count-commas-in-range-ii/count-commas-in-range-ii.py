class Solution:
    def countCommas(self, n: int) -> int:
        ans = 0
        if n >= 10**3:
            ans += n - 999
        if n >= 10**6:
            ans += n - 999999
        if n >= 10**9:
            ans += n - 999999999
        if n >= 10**12:
            ans += n - 999999999999
        if n >= 10**15:
            ans += n - 999999999999999
        return ans