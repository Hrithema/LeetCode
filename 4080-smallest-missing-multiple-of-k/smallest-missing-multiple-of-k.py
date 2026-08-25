class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        for i in range (1, 1000):
            n = k * i
            if n not in nums:
                return n
        return -1