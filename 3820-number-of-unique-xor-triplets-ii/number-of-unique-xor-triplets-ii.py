class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        max_val = max(nums)
        limit = 1
        while limit <= max_val:
            limit <<= 1
        
        # s1[x] will be True if x can be formed by a ^ b
        s1 = [False] * limit
        n = len(nums)
        
        # Step 1: Compute all possible pair XORs
        for i in range(n):
            for j in range(i, n):
                s1[nums[i] ^ nums[j]] = True
        
        # Unique elements in nums to avoid redundant inner loop checks
        unique_nums = set(nums)
        
        # Step 2: Combine pair XORs with single elements
        s2 = [False] * limit
        for x in range(limit):
            if s1[x]:
                for num in unique_nums:
                    s2[x ^ num] = True
                    
        return sum(s2)