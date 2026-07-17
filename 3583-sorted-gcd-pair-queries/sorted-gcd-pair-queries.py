from typing import List
from bisect import bisect_right

class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        mx = max(nums)

        # freq[x] = how many times x appears
        freq = [0] * (mx + 1)
        for num in nums:
            freq[num] += 1

        # exact[g] = number of pairs whose GCD is exactly g
        exact = [0] * (mx + 1)

        # Process GCD values from largest to smallest
        for g in range(mx, 0, -1):

            # Count numbers divisible by g
            cnt = 0
            for multiple in range(g, mx + 1, g):
                cnt += freq[multiple]

            # Total pairs whose GCD is a multiple of g
            pairs = cnt * (cnt - 1) // 2

            # Remove pairs already counted for larger GCDs
            for multiple in range(2 * g, mx + 1, g):
                pairs -= exact[multiple]

            exact[g] = pairs

        # prefix[i] = total pairs with GCD <= i
        prefix = []
        values = []

        total = 0
        for g in range(1, mx + 1):
            if exact[g] > 0:
                total += exact[g]
                prefix.append(total)
                values.append(g)

        ans = []

        for q in queries:
            idx = bisect_right(prefix, q)
            ans.append(values[idx])

        return ans