class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        max_val = max(nums)
        limit = 1
        while limit <= max_val:
        s1 = [False] * limit
        n = len(nums)
        for i in range(n):
            for j in range(i, n):
                s1[nums[i] ^ nums[j]] = True
        unique_nums = set(nums)
        s2 = [False] * limit
        for x in range(limit):
            if s1[x]:
                for num in unique_nums:
                    s2[x ^ num] = True
                    
        return sum(s2)
