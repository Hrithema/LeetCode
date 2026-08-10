class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        ans = [False] * (n+1)
        for i in range (1, n+1):
            for j in range(1, math.isqrt(i)+1):
                square = j* j
                if not ans [i - square]:
                    ans [i] = True
                    break
        return ans [n]