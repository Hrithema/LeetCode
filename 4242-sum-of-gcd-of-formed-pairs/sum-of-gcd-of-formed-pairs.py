
class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        mxi = 0
        prefixGcd = []
        for i in range(0, len(nums)):
            mxi = max(mxi, nums[i])
            prefixGcd.append( gcd(nums[i], mxi))
        prefixGcd.sort()
        left = 0
        right = len(prefixGcd) -1
        sumgcd = 0
        while left < right:
            sumgcd += gcd(prefixGcd[left], prefixGcd[right])
            left+=1
            right-=1
        return sumgcd