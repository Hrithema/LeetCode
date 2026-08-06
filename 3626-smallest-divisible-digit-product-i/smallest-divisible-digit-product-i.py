class Solution:
    def smallestNumber(self, n: int, t: int) -> int:

        while True:
            nums = [int(digit) for digit in str(n)]
            prod = 1
            for i in range(len(nums)):
                prod *= nums[i]
            if prod % t == 0:
                return n
            n += 1
