class Solution:
    def findGCD(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)-1
        return gcd(nums[0], nums[n])