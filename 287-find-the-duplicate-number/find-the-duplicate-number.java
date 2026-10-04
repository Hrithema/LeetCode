class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(mx<nums[i]){
                mx = nums[i];
            }
        }
        int [] freq= new int [mx+1];
        for(int i = 0; i< nums.length; i++){
            freq[nums[i]]+= 1;
        }
        for(int i = 0; i<freq.length; i++){
            if(freq[i] > 1){
                return i;
            }
        }
        return -1;
    }
}