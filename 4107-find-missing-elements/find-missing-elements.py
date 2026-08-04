class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        nums.sort()
        ans = []
        for i in range (1, len(nums)):
            for x in range (nums[i-1]+1, nums[i]):
                ans.append(x)      
        return ans