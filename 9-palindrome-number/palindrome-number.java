class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x / 10 == 0) return true;
        int original = x;
        int reversed = 0;
        while(original > 0){
            reversed *= 10;
            reversed += original % 10;
            original/= 10;
        } 
        return (reversed == x);
    }
}