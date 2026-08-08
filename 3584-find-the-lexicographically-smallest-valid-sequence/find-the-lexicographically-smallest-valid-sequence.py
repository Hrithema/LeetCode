class Solution:
    def validSequence(self, word1: str, word2: str) -> list[int]:
        n = len(word1)
        m = len(word2)

        if m > n:
            return []

        # suffix[j] = latest index in word1 that can be used
        # as word2[j] while matching word2[j:] exactly.
        #
        # Example:
        # word2[j:] can be matched exactly starting somewhere
        # before suffix[j].
        suffix = [-1] * (m + 1)

        # Empty suffix can start anywhere.
        suffix[m] = n

        i = n - 1

        # Match word2 from right to left.
        for j in range(m - 1, -1, -1):
            while i >= 0 and word1[i] != word2[j]:
                i -= 1

            if i < 0:
                break

            suffix[j] = i
            i -= 1

        # If the complete word2 cannot be matched exactly,
        # suffix[0] will be -1, but a single mismatch may still
        # make it possible.

        ans = []
        i = 0
        mismatch_used = False

        for j in range(m):

            # Find the earliest exact match.
            while i < n and word1[i] != word2[j]:
                # We can potentially use this position as our
                # one mismatch, but only if the remaining suffix
                # can be matched exactly.
                if not mismatch_used:
                    if j == m - 1:
                        # Last character: no suffix remains.
                        ans.append(i)
                        return ans

                    # suffix[j + 1] is the latest possible index
                    # for word2[j + 1].
                    #
                    # Therefore i must be strictly before it.
                    if suffix[j + 1] > i:
                        ans.append(i)
                        mismatch_used = True
                        i += 1
                        break

                i += 1
            else:
                # No exact match was found.
                if i >= n:
                    return []

                # Exact match.
                ans.append(i)
                i += 1
                continue

            # We used a mismatch.
            if mismatch_used:
                # Match the remaining characters exactly.
                for k in range(j + 1, m):
                    while i < n and word1[i] != word2[k]:
                        i += 1

                    if i >= n:
                        return []

                    ans.append(i)
                    i += 1

                return ans

        return ans