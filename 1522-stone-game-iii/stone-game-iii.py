class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        n = len(stoneValue)

        memo = [None] * n
        def solve(i):
            if i>= n:
                return 0
            if memo[i] is not None:
                return memo[i]
            best = float('-inf')
            currentSum =0

            for k in range (3):
                if i + k < n:
                    currentSum += stoneValue[i+k]
                    difference = currentSum - solve(i + k +1)
                    best = max(best, difference)
            memo [i] = best
            return best

        difference = solve(0)
        if difference > 0:
            return "Alice"
        elif difference < 0:
            return "Bob"
        else:
            return "Tie"