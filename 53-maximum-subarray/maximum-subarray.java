class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i< nums.length; i++){
            currSum += nums[i];
            if(currSum < nums[i]){
                currSum = nums[i];
            }
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}