class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        nums = set(nums)
        for i in range (1, len(nums) + 2):
            n = k * i
            if n not in nums:
                return n
        