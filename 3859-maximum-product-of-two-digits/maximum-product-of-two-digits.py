class Solution:
    def maxProduct(self, n: int) -> int:
        r = [int(digit) for digit in str(n)]
        r.sort(reverse = True)
        return r[0] * r[1]