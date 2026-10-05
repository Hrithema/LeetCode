class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length-1;
        int [] prefix = new int [nums.length];
        int [] suffix = new int [nums.length];
        prefix[0] = 1; suffix[nums.length-1] = 1;

        int [] ans = new int [nums.length];
        for(int i = 1; i<nums.length; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
            suffix[n-i] = nums[n-i+1] * suffix[n-i+1];
        }
        for(int i = 0; i< nums.length; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
}