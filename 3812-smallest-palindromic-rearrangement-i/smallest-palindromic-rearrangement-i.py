class Solution:
    def smallestPalindrome(self, s: str) -> str:
        if len(s)== 1:
            return s
        freq = Counter(s)
        left = []
        mid = ""

        for ch in sorted(freq):
            left.append(ch*(freq[ch]//2))
            if freq[ch] % 2 == 1:
                mid = ch
        left = "".join(left)
        return left + mid + left[:: -1]