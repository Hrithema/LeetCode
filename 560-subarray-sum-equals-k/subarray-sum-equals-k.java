class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // Arrays.sort(nums);
        for(int i =0; i<nums.length; i++){
            int sum = 0;
            // if(nums[i] > k) continue;
            for(int j = i; j<nums.length; j++){
                sum += nums[j];
                if(sum == k) {
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
}