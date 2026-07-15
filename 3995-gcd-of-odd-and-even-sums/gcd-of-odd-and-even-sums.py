class Solution:
    def gcdOfOddEvenSums(self, n: int) -> int:
        odd = 1
        even = 2
        sumOdd = 0 
        sumEven = 0
        while n != 0:
            sumOdd+= odd
            sumEven += even
            odd+=2
            even+=2
            n-=1
        return gcd(sumEven, sumOdd)