class Solution:
    def isPalindrome(self, s: str) -> bool:
        clean = [c.lower() for c in s if c.isalnum()]
        left, right = 0, len(clean)-1
        while left<right:
            if clean[right] != clean[left]:
                return False
            left +=1 
            right -= 1
        return True