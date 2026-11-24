class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length-1;
        int [] ans = new int[n+1];

        ans[0] = 1;

        // prefix
        for(int i = 1; i<=n; i++){
            ans[i] = nums[i-1]*ans[i-1];
        }

        // suffix
        int suffix = 1;
        for(int i = n-1; i>=0; i--){
            suffix *= nums[i+1];
            ans[i] *= suffix;
        }
        return ans;
    }
}