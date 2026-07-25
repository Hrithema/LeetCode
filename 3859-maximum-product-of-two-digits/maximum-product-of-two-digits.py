class Solution:
    def maxProduct(self, n: int) -> int:
        first = second = 0
        for num in str(n):
            digit = int(num)
            if digit >= first:
                second = first
                first = digit
            elif digit > second:
                second = digit
        return first * second