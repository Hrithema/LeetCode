class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)
        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]

        dp = [[0] * n for _ in range(n)]

        size = 1
        while size < n:
            size *= 2

        NEG = -10**30

        left_tree = [
            [NEG] * (2 * size)
            for _ in range(n)
        ]
        right_tree = [
            [NEG] * (2 * size)
            for _ in range(n)
        ]

        def update(tree, pos, value):
            pos += size
            tree[pos] = value

            pos //= 2

            while pos:
                tree[pos] = max(
                    tree[pos * 2],
                    tree[pos * 2 + 1]
                )
                pos //= 2

        def query(tree, left, right):
            if left > right:
                return NEG

            left += size
            right += size

            ans = NEG

            while left <= right:
                if left & 1:
                    ans = max(ans, tree[left])
                    left += 1

                if not (right & 1):
                    ans = max(ans, tree[right])
                    right -= 1

                left //= 2
                right //= 2

            return ans
        for i in range(n):
            update(
                left_tree[i],
                i,
                prefix[i + 1]
            )

        for i in range(1, n):
            update(
                right_tree[i],
                i - 1,
                -prefix[i]
            )

        for length in range(2, n + 1):

            for l in range(n - length + 1):
                r = l + length - 1

                total = prefix[r + 1] - prefix[l]

                lo = l
                hi = r - 1

                while lo < hi:
                    mid = (lo + hi) // 2

                    left_sum = (
                        prefix[mid + 1] - prefix[l]
                    )

                    if 2 * left_sum >= total:
                        hi = mid
                    else:
                        lo = mid + 1

                k = lo

                left_sum = prefix[k + 1] - prefix[l]

                best = 0

                if 2 * left_sum < total:

                    best = max(
                        best,
                        query(
                            left_tree[l],
                            l,
                            r - 1
                        ) - prefix[l]
                    )

                else:
                    if k > l:
                        best = max(
                            best,
                            query(
                                left_tree[l],
                                l,
                                k - 1
                            ) - prefix[l]
                        )

                    best = max(
                        best,
                        total
                        + prefix[l]
                        + query(
                            right_tree[r],
                            k,
                            r - 1
                        )
                    )

                    if 2 * left_sum == total:
                        best = max(
                            best,
                            left_sum + dp[l][k],
                            left_sum + dp[k + 1][r]
                        )

                dp[l][r] = best

                update(
                    left_tree[l],
                    r,
                    dp[l][r] + prefix[r + 1]
                )
                if l > 0:
                    update(
                        right_tree[r],
                        l - 1,
                        dp[l][r] - prefix[l]
                    )

        return dp[0][n - 1]